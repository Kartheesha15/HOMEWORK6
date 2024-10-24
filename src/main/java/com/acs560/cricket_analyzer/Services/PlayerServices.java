

package com.acs560.cricket_analyzer.Services;
import com.acs560.cricket_analyzer.model.Player ;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//@Service
public interface PlayerServices {
	
	Optional<Player> getPlayers(String name, int countryId);
	List<Player> getPlayers();
	List<Player> getPlayersByCountry(int countryId);
	List<Player> getPlayersByCountryAndNotouts(int countryId, int notouts);

	Player add(@Valid Player player);
	boolean delete(@Valid Player player);
	Player update(@Valid Player player);

	

}
