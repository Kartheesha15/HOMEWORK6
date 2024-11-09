package com.acs560.cricket_analyzer.Repository;

import org.springframework.data.repository.CrudRepository;

import com.acs560.cricket_analyzer.entities.CountryEntity;


public interface CountriesRepository extends CrudRepository<CountryEntity, Long> {

	CountryEntity findByTeam(String team);
	
}


