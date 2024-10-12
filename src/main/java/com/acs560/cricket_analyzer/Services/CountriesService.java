package com.acs560.cricket_analyzer.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;

import com.acs560.cricket_analyzer.model.Country;
import com.acs560.cricket_analyzer.requests.CountryRequest;
import jakarta.validation.Valid;
public interface CountriesService {

	List<Country> getCompanies();
	
	Optional<Country> getCountry(int id);
	
	Country addCountry(@Valid CountryRequest c);
	Country updateCountry(int id, CountryRequest c);
	boolean deleteCountry(int id);

	
	
}
