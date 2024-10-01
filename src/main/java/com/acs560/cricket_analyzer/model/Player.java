package com.acs560.cricket_analyzer.model;

import java.util.Objects;

import com.acs560.cricket_analyzer.entities.PlayerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
	private String name;
	private String team;
	private int matches;
	private int innings;
	private int notouts;
	private int runs;
	private double average;
	private double strikeRate;
	
	@Override
	public int hashCode() {
		return Objects.hash(matches, innings, notouts, runs, average, strikeRate );
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return runs == other.runs && average == other.average &&
				Objects.equals(name, other.name);
	}
	public Player(String name,String team,int matches,int innings,int notouts, int runs, double average,double strikeRate) {
		this.name = name;
		this.team = team;
		this.matches = matches;
		this.innings = innings;
		this.notouts = notouts;
		this.runs = runs;
		this.average = average;
		this.strikeRate = strikeRate;
	}
	
	public Player(PlayerEntity be) {
		this(be.getId(),
				be.getId().getTeams(),
				be.getId().getMatches(),
				be.getId().getInnings(),
				be.getId().getNotouts(),
				be.getRuns(),
				be.getId().getAverage(),
				be.getId().getStrikeRate());
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public int getNotouts() {
		return notouts;
	}
	public void setNotouts(int notouts) {
		this.notouts = notouts;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}


}
