package com.acs560.cricket_analyzer.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;

import lombok.NoArgsConstructor;


@RestController()
@RequestMapping("/api/v1/players")
//@NoArgsConstructor
public class PlayerController {

	
//	@Autowired
	private PlayerServices playerServices;
	

	@Autowired
	public PlayerController(PlayerServices playerServices) {
		this.playerServices = playerServices;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Player>> getPlayers() {
		return ResponseEntity.ok(playerServices.getPlayers());
	}
	
	@GetMapping("/{name}/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable String name ,@PathVariable int countryId) {
		
		Optional<Player> player = playerServices.getPlayers(name, countryId);
		
		ResponseEntity<Player> response =
				player.isPresent() ? ResponseEntity.ok(player.get()) : ResponseEntity.notFound().build();
		
		return response;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Player>> getPlayersByCountry(@PathVariable int countryId){
		return ResponseEntity.ok(playerServices.getPlayersByCountry(countryId));
	}
	
	@GetMapping("/{id}/{notouts}")
	public ResponseEntity<List<Player>> getPlayersByCountryAndNotouts(@PathVariable int countryId ,@PathVariable int notouts){
		return ResponseEntity.ok(playerServices.getPlayersByCountryAndNotouts(countryId, notouts));
	}
	

	@PostMapping()
	public ResponseEntity<Player> add(@RequestBody Player player){
		playerServices.add(player);
		
		return ResponseEntity.created(null).build();
	}
	
	
	
	@PutMapping()
	public ResponseEntity<Player> update(@RequestBody Player player){
		playerServices.update(player);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping()
	public ResponseEntity<Player> delete(@RequestBody Player player){
		playerServices.delete(player);
		
		return ResponseEntity.ok().build();
	}
}

