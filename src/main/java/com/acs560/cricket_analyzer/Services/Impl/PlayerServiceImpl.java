package com.acs560.cricket_analyzer.Services.Impl;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.entities.PlayerEntity;
import com.acs560.cricket_analyzer.entities.PlayerEntityId;
import com.acs560.cricket_analyzer.model.Player;
@Service
public class PlayerServiceImpl implements PlayerServices {

	@Autowired
	PlayerRepository br;

	@Override
	public Optional<Player> getPlayers(String name, String team) {
		PlayerEntityId id = new PlayerEntityId(name, team);
		var be = br.findById(id);
		Optional<Player> result = be.isPresent() ? Optional.of(new Player(be.get())) : Optional.empty(); 
		
		return result;
	}

	@Override
	public List<Player> getPlayers() {
		var playerEntities = ((List<PlayerEntity>) br.findAll());
		return from(playerEntities);
	}

	@Override
	public List<Player> getPlayers(String name) {
		var playerEntities = br.findAllByIdName(name);
		return from(playerEntities);
	}

	@Override
	public void add(Player player) {
PlayerEntity playerToAdd = new PlayerEntity(player);
		
		if (exists(playerToAdd)) {
			throw new IllegalArgumentException("Player already exists");
		}
		
		br.save(playerToAdd);

		
	}

	@Override
	public void delete(Player player) {
		PlayerEntity playerToDelete = new PlayerEntity(player);
		
		if (!exists(playerToDelete)) {
			throw new NoSuchElementException("Player does not exist");
		}
		
		br.delete(new PlayerEntity(player));
		
	}

	@Override
	public void update(Player player) {
PlayerEntity playerToUpdate = new PlayerEntity(player);
		
		if (!exists(playerToUpdate)) {
			throw new NoSuchElementException("Player does not exist");
		}
		
		br.save(new PlayerEntity(player));
		
	}

	@Override
	public List<Player> getPlayers(int matches) {
		var playerEntities = br.findAllByIdMatches(matches);
		return from(playerEntities);
	}
	private List<Player> from(List<PlayerEntity> playerEntities){
		var players = playerEntities.stream()
				.map(be -> new Player(be))
				.collect(Collectors.toList());

		if (players.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		players.sort(Comparator.comparing(Player::getName)
				.thenComparing(Player::getTeam)
				.thenComparing(Player::getRuns));
		return players;
	}
	
	private boolean exists(PlayerEntity be) {
		return br.existsById(be.getId());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	@Override
	public List<Player> getPlayers(String name, String team) {
		List<Player> filteredPlayers = 
				new ArrayList<>(PlayerRepository.getPlayers()
						.stream()
						.filter(b -> b.getName().equals(name) && b.getName().equals(team))
						.toList());
		
		if (filteredPlayers.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		filteredPlayers.sort(createPlayerComparator());
		return filteredPlayers;

	}

	@Override
	public List<Player> getPlayers() {
		List<Player> players = PlayerRepository.getPlayers();
		players.sort(createPlayerComparator());
		return players;
	}

	@Override
	public List<Player> getPlayers(String name) {
		List<Player> filteredPlayers = new ArrayList<>(PlayerRepository.getPlayers().stream().filter(b -> b.getName().equals(name)).toList());
		if (filteredPlayers.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		filteredPlayers.sort(createPlayerComparator());
		return filteredPlayers;
	}
	
	private Comparator<Player> createPlayerComparator(){
		return Comparator.comparing(Player::getTeam).
				thenComparing(Player::getRuns).
				thenComparing(Player::getAverage);
	}

	@Override
	public void add(Player player) {
		PlayerRepository.addPlayer(player);
		
	}

	@Override
	public void delete(Player player) {
		PlayerRepository.addPlayer(player);
		
	}

	@Override
	public void update(Player player) {
		PlayerRepository.updatePlayer(player);
		
	}
	*/
}
