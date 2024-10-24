

package com.acs560.cricket_analyzer.Services.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;




@Service
public class AnalysisServicesImpl implements AnalysisServices {

//	@Autowired
	private PlayerRepository br;
	
	@Autowired
	public AnalysisServicesImpl(PlayerRepository br) {
		this.br = br;
	}

	

	@Override
	public double calculateAverage(int matches)  {
		var average = br.calculateAverage(matches);
		
		if (average == null) {
			throw new NoSuchElementException("No such players exist");
		}
		
		return average;

	}
	
	public double calculateAverageRuns(int matches, int companyId) {
		var average = br.calculateAverage(matches, companyId);
		
		if (average == null) {
			throw new NoSuchElementException("No such players exist");
		}
		
		return average;
	}

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

	






