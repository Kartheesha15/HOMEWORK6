

package com.acs560.cricket_analyzer.Services;
import com.acs560.cricket_analyzer.model.Player ;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;


public interface PlayerServices {
	
	Optional<Player> getPlayers(String name, Long countryId);
	List<Player> getPlayers();
	List<Player> getPlayersByCountry(Long countryId);
	List<Player> getPlayersByCountryAndNotouts(Long countryId, int notouts);

	Player add(@Valid Player player);
	boolean delete(@Valid Player player);
	Player update(@Valid Player player);

	

}
