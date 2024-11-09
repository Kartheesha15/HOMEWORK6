package com.acs560.cricket_analyzer.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.acs560.cricket_analyzer.model.Country;
import com.acs560.cricket_analyzer.requests.CountryRequest;
import jakarta.validation.Valid;

@Service
public interface CountriesService {

	List<Country> getCountries();
	
	Optional<Country> getCountry(Long id);
	
	Country addCountry(@Valid CountryRequest c);
	Country updateCountry(Long id, CountryRequest c);
	boolean deleteCountry(Long id);

	
	
}
