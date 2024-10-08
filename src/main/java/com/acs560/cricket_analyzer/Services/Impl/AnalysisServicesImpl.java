

package com.acs560.cricket_analyzer.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;




@Service
public class AnalysisServicesImpl implements AnalysisServices {

//	@Autowired
	PlayerServices playerServices;
	

	@Override
	public double calculateAverageRuns(String team) {
		List<Player> players = playerServices.getPlayers(team);
		return getAverageRuns(players);

	}

	@Override
	public double calculateAverageStrikeRate(String team) {
		List<Player> players = playerServices.getPlayers(team);
		return getAverageStrikeRate(players);
	}

	@Override
	public double calculateAverageNotOuts(String team) {
		List<Player> players = playerServices.getPlayers(team);
		return getAverageNotOuts(players);
	}

	@Override
	public double calculateAverageInningsbyTeam(String team) {
		List<Player> players = playerServices.getPlayers(team);
		return getAverageInnings(players);
	}

	@Override
	public double calculateAverageMatchesbyTeam(String team) {
		List<Player> players = playerServices.getPlayers(team);
		return getAverageMatches(players);
	}

	private double getAverageRuns(List<Player> players) {
		double average = players
				.stream()
				.mapToDouble(Player::getRuns)
				.average()
				.orElseThrow();
		return average;
	}

	private double getAverageStrikeRate(List<Player> players) {
		double average = players
				.stream()
				.mapToDouble(Player::getStrikeRate)
				.average()
				.orElseThrow();
		return average;
	}
	
	private double getAverageNotOuts(List<Player> players) {
		double average = players
				.stream()
				.mapToDouble(Player::getNotouts)
				.average()
				.orElseThrow();
		return average;
	}
	private double getAverageInnings(List<Player> players) {
		double average = players
				.stream()
				.mapToDouble(Player::getInnings)
				.average()
				.orElseThrow();
		return average;
	}
	private double getAverageMatches(List<Player> players) {
		double average = players
				.stream()
				.mapToDouble(Player::getMatches)
				.average()
				.orElseThrow();
		return average;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Override
	public double calculateAverageRuns(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getRuns).average().orElseThrow();
		return average;
	}
	
	public String CompareRuns(String team1, String team2) {
		 if (calculateAverageRuns(team1) > calculateAverageRuns(team2)) {
            return team1;
         }
		 else {
		return team2;
		 }
	}

	@Override
	public double calculateAverageStrikeRate(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getStrikeRate).average().orElseThrow();
		return average;
	}

	@Override
	public double calculateAverageNotOuts(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getNotouts).average().orElseThrow();
		return average;
	}
	
	@Override
	public double calculateAverageInningsbyTeam(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getInnings).average().orElseThrow();
		return average;
	}
	@Override
	public double calculateAverageMatchesbyTeam(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getMatches).average().orElseThrow();
		return average;
	}
*/

	





}
