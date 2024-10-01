package com.acs560.cricket_analyzer.Services;
import com.acs560.cricket_analyzer.model.Player ;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface PlayerServices {
	
	Optional<Player> getPlayers(String name, String team);
	List<Player> getPlayers();
	List<Player> getPlayers(String name);
//	List<Player> getPlayers(String team, int runs);
	
	
	void add(Player player);
	void delete(Player player);
	void update(Player player);
	
	List<Player> getPlayers(int matches);
	
//	List<Player> getPlayers(int month, int range);

//	List<Player> getPlayers(String name, int month, int range);
	

	

}
