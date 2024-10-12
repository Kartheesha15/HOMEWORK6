package com.acs560.cricket_analyzer.entities;


import com.acs560.cricket_analyzer.model.Country;
import com.acs560.cricket_analyzer.requests.CountryRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "companies")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CountryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String team;
	
	public CountryEntity (CountryRequest c) {
		this.team = c.getTeam();
	}
	
	public CountryEntity(Country c) {
		this(c.getId(), c.getTeam());
	}

}
