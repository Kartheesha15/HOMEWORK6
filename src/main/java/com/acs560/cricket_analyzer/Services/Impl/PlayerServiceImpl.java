

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
import java.util.Collections;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.entities.PlayerEntity;
import com.acs560.cricket_analyzer.entities.PlayerEntityId;
import com.acs560.cricket_analyzer.model.Player;

import jakarta.validation.Valid;
@Service
public class PlayerServiceImpl implements PlayerServices {

//	@Autowired
	private PlayerRepository br;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository br) {
		this.br = br;
	}

	@Override
	public Optional<Player> getPlayers(String name, int companyId) {
		PlayerEntityId id = new PlayerEntityId(name, companyId);
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
	public List<Player> getPlayersByCountry(int countryId) {
		var playerEntities = br.findAllByIdCountryId(countryId);
		return from(playerEntities);
	}
	
	@Override
	public List<Player> getPlayersByCountryAndNotouts(int countryId, int notouts) {
		var playerEntities = br.findAllByIdCountryIdAndNotouts(countryId, notouts);
		return from(playerEntities);
	}


	@Override
	public Player add(@Valid Player player) {
		Player addedPlayer = null;
		
		PlayerEntity playerToAdd = new PlayerEntity(player);
		
		if (!br.existsById(playerToAdd.getId())) {
			var playerEntity = br.save(playerToAdd);
			addedPlayer = new Player(playerEntity);
		}

		return addedPlayer;
	}

	@Override
	public boolean delete(@Valid Player player) {
		boolean isDeleted = false;
		PlayerEntity playerToDelete = new PlayerEntity(player);
		
		if (br.existsById(playerToDelete.getId())) {
			br.delete(new PlayerEntity(player));
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Player update(@Valid Player player) {
		Player updatedPlayer = null;
		
		PlayerEntity playerToUpdate = new PlayerEntity(player);
		
		if (br.existsById(playerToUpdate.getId())) {
			var updatedPlayerEntity = br.save(new PlayerEntity(player));
			updatedPlayer = new Player(updatedPlayerEntity);
		}

		return updatedPlayer;
	}

	private List<Player> from(List<PlayerEntity> playerEntities){
		var players = playerEntities.stream()
				.map(be -> new Player(be))
				.collect(Collectors.toList());

		if (players.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Collections.sort(players);
		
		return players;
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
