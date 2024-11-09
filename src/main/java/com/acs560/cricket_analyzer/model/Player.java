package com.acs560.cricket_analyzer.model;

import java.util.Objects;

import com.acs560.cricket_analyzer.entities.PlayerEntity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {

	
	@NotNull(message="Name is required")
	private String name;
	
	@NotNull(message="Country is required")
	private Long countryId;
	
//	@NotNull(message="Team is required")
//	private String team;
	@NotNull(message="matches is required")
	private Integer matches;
	@NotNull(message="innings is required")
	private Integer innings;	
	@NotNull(message="notouts is required")
	private Integer notouts;
	@NotNull(message="runs is required")
	private Integer runs;
	@NotNull(message="Average is required")
	private Double average;
	@NotNull(message="strikeRate is required")
	private Double strikeRate;

	

	@Override
	public int hashCode() {
		return Objects.hash(name,countryId,matches, innings, notouts, runs, average );
	}
//	public int hashCode() {
//		return Objects.hash(name,countryId,matches, innings, notouts, runs, average );
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name,  other.name) && Objects.equals(countryId, other.countryId) &&
				Objects.equals(matches, other.matches) && Objects.equals(innings, other.innings)
				 && Objects.equals(notouts, other.notouts) && Objects.equals(runs, other.runs)
				 && Objects.equals(average, other.average);
//		return runs == other.runs && average == other.average &&
	//			Objects.equals(name, other.name);
	}

	
	public Player(PlayerEntity pe) {
		this(pe.getId().getName(),
				pe.getId().getCountryId(),
				pe.getMatches(),
				pe.getInnings(),
				pe.getNotouts(),
				pe.getRuns(),
				pe.getAverage(),
				pe.getStrikerate());
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getTeam() {
//		return country;
//	}
//	public void setTeam(String team) {
//		this.country = country;
//	}
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

//	@Override
//	public int compareTo(Player o) {
//		return Comparator.comparing(Player::getName)
//				.thenComparing(b-> b.getCountry().compareTo(o.getCountry()))
//				.compare(this, o);
//	}
	
	


}
