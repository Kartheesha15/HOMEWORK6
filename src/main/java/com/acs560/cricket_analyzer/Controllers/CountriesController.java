package com.acs560.cricket_analyzer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.CountriesService;
import com.acs560.cricket_analyzer.model.Country;
import com.acs560.cricket_analyzer.requests.CountryRequest;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/api/v1/countries")
public class CountriesController {
private CountriesService cs;
	
//	@Autowired
	public CountriesController(CountriesService cs) {
		this.cs = cs;
	}
	
	@GetMapping
	public ResponseEntity<List<Country>> getCompanies(){
		return ResponseEntity.ok(cs.getCompanies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable int id){
		var country = cs.getCountry(id);
		
		return country.isPresent() ? 
				ResponseEntity.ok(country.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Country> addCountry(@Valid @RequestBody CountryRequest c){
		var addedCountry = cs.addCountry(c);
		
		return ResponseEntity.created(null).body(addedCountry);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Country> addCountry(@PathVariable int id,
			@Valid @RequestBody CountryRequest c){

			cs.updateCountry(id, c);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable int id){
		cs.deleteCountry(id);
		
		return ResponseEntity.ok().build();
	}

}
