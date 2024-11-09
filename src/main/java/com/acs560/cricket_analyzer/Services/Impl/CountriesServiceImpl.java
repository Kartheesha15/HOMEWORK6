package com.acs560.cricket_analyzer.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.CountriesRepository;
import com.acs560.cricket_analyzer.Services.CountriesService;
import com.acs560.cricket_analyzer.entities.CountryEntity;
import com.acs560.cricket_analyzer.model.Country;
import com.acs560.cricket_analyzer.requests.CountryRequest;

@Service
public class CountriesServiceImpl implements CountriesService {
private CountriesRepository cr;
	
	@Autowired
	public CountriesServiceImpl(CountriesRepository cr) {
		this.cr = cr;
	}

	@Override
	public List<Country> getCountries() {
		var countryEntities = cr.findAll();
		List<Country> countries = new ArrayList<>();
		countryEntities.forEach(ce -> countries.add(new Country(ce)));
		
		return countries;
	}

	@Override
	public Optional<Country> getCountry(Long id) {
		var ce = cr.findById(id);
		Optional<Country> company = 
				ce.isPresent() ? Optional.of(new Country(ce.get())) : Optional.empty();
		
		return company;
	}

	@Override
	public Country addCountry(CountryRequest c) {
		var companyToAdd = new CountryEntity(c);	
		
		var companyEntity = cr.save(companyToAdd);
		
		return new Country(companyEntity);
	}

	@Override
	public Country updateCountry(Long id, CountryRequest c) {
		Country updatedCountry = null;
		
		if (cr.existsById(id)) {
			var companyEntity = cr.save(new CountryEntity(id, c.getTeam()));
			updatedCountry = new Country(companyEntity);
		} 
		
		return updatedCountry;
	}

	@Override
	public boolean deleteCountry(Long id) {
		boolean isDeleted = false;
		
		if (cr.existsById(id)) {
			cr.deleteById(id);
			isDeleted = true;
		}
		
		return isDeleted;
	}


}
