package com.acs560.cricket_analyzer.model;

import com.acs560.cricket_analyzer.entities.CountryEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Country implements Comparable<Country> {
	private int id;
	private String team;
	
	public Country(CountryEntity ce) {
		this(ce.getId(), ce.getTeam());
	}

	@Override
	public int compareTo(Country o) {
		return team.compareTo(o.team);
	}

}
