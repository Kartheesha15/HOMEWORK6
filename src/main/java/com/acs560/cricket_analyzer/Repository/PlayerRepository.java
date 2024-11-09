
/*import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.acs560.cricket_analyzer.model.Player;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class PlayerRepository {

    private static List<Player> players;

    public static List<Player> getPlayers() {
        if (players == null) {
            players = initializePlayers();
        }
        return players;
    }

    private static List<Player> initializePlayers() {
    	CSVReader reader;
  //      List<Player> players = new ArrayList<>();
        try {
        	reader = new CSVReader(new FileReader("batting_stats.csv"));
            ColumnPositionMappingStrategy<Player> beanStrategy = new ColumnPositionMappingStrategy<Player>();
            beanStrategy.setType(Player.class);
            beanStrategy.setColumnMapping(new String[]{"name", "team", "matches", "innings", "notouts", "runs", "average", "strike_rate"});

            CsvToBean<Player> csvToBean = new CsvToBean<Player>();
            csvToBean.setCsvReader(reader);
            csvToBean.setMappingStrategy(beanStrategy);

            players = csvToBean.parse();
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return players;
    }

    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    
 
    public List<Player> getPlayersByTeam(String team) {
        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getTeam().equals(team)) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

	public double getRuns() {
		
		return 0;
	}

    }
    
*/

package com.acs560.cricket_analyzer.Repository;


import java.util.List;
import java.util.Set;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.acs560.cricket_analyzer.entities.PlayerEntity;
import com.acs560.cricket_analyzer.entities.PlayerEntityId;


public interface PlayerRepository extends CrudRepository<PlayerEntity, PlayerEntityId> {

	List<PlayerEntity> findAllByIdCountryId(Long countryId);
	
	List<PlayerEntity> findAllByIdCountryIdAndNotouts(Long countryId, int notouts);
	
//	List<PlayerEntity> findAllByIdTeam(String team);
	@Query(value = """
			SELECT AVG(runs) FROM players WHERE matches = ?8
			""", nativeQuery=true)
	Double calculateAverage(int matches);
	
	@Query(value = """
			SELECT AVG(runs) FROM players WHERE matches = ?8 AND country_id = ?2
			""", nativeQuery=true)
	Double calculateAverage(int matches, Long countryId);
	
	@Query(value = """
			SELECT AVG(runs) FROM players WHERE matches in ?8
			""", nativeQuery=true)
	Double calculateAverage(Set<Integer> matches);
	
	@Query(value = """
			SELECT AVG(runs) FROM players WHERE matches in ?8 AND country_id = ?2
			""", nativeQuery=true)
	Double calculateAverage(Set<Integer> matches, Long countryId);

	
//	List<PlayerEntity> findAllByIdNameAndIdRuns(String name, Set<Integer> runs);

//	List<PlayerEntity> findAllByMatches(int matches);

}


/*public class PlayerRepository {

    private static List<Player> players;

    
    static {
    	if(players == null) {
    		players = initializePlayers();
    	}
    }
    
    public static List<Player> getPlayers(){
    	return players;
    }
    public static List<Player> getPlayers(Predicate<Player> predicate){
    	return players.stream().filter(predicate).toList();
    }
    private static List<Player> initializePlayers() {
        CSVReader reader;
       // List<Player> players = new ArrayList<>();
        try {
            reader = new CSVReader(new FileReader("batting stats.csv"));
            reader.readNext();
            ColumnPositionMappingStrategy<Player> beanStrategy = new ColumnPositionMappingStrategy<Player>();
            beanStrategy.setType(Player.class);
            beanStrategy.setColumnMapping(new String[]{"name", "team", "matches", "innings", "notouts", "runs", "average", "strikeRate"});
            CsvToBean<Player> csvToBean = new CsvToBean<Player>();
            csvToBean.setCsvReader(reader);
            csvToBean.setMappingStrategy(beanStrategy);

            players = csvToBean.parse();
        } catch (FileNotFoundException e) {
           players = new ArrayList<>();
        } catch (IOException e) {
        	 players = new ArrayList<>();
			e.printStackTrace();
		} catch (CsvValidationException e) {
			 players = new ArrayList<>();
			e.printStackTrace();
		}
        return players;
    }


public static void addPlayer(Player player) {
/*	if(player.contains(player)) {
		throw new IllegalArgumentException("player already exists");
	}

	
	if(savePlayer(player)) {
		players.add(player);
	}else {
		throw new PlayerRepositoryManagementException("Error adding player");
	}
}

public static void updatePlayer(Player player) {
	
	int index = players.indexOf(player);
	
	if (index == -1) {
		throw new IllegalArgumentException("Error updating player - does not exist");
	}
	
	Player backup = players.get(index);
	players.set(index, player);
	
	if (!savePlayers()) {
		players.set(index, backup);
		throw new PlayerRepositoryManagementException("Error updating player");
	}
}

public static void deletePlayer(Player player) {
	
	if (!players.remove(player)) {
		throw new IllegalArgumentException("Error deleting player - does not exist");
	}
	
	if (!savePlayers()) {
		players.add(player);
		throw new PlayerRepositoryManagementException("Error deleting player");
	}
}


private static StatefulBeanToCsv<Player> createWriter(FileWriter writer) {
	ColumnPositionMappingStrategy<Player> mappingStrategy = 
			new ColumnPositionMappingStrategy<>();
	mappingStrategy.setType(Player.class);

	mappingStrategy.setColumnMapping(new String[]{"name", "team", "matches", "innings", "notouts", "runs", "average", "strikeRate"});
	
	StatefulBeanToCsv<Player> beanWriter = new StatefulBeanToCsvBuilder<Player>(writer)
	    .withMappingStrategy(mappingStrategy)
	    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	    .build();
	return beanWriter;
}

private static boolean savePlayer(Player player) {
	boolean isSaved = false;
	
	try (FileWriter writer = new FileWriter("batting stats.csv", true)) {
	    StatefulBeanToCsv<Player> beanWriter = createWriter(writer);
	    
	    beanWriter.write(player);
		isSaved = true;
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}catch (CsvDataTypeMismatchException e) {
		System.err.println(e.getMessage());
	}catch (CsvRequiredFieldEmptyException e) {
		System.err.println(e.getMessage());
	}
	

	return isSaved;
}

private static boolean savePlayers() {
	
	boolean isSaved = false;
	
	try (FileWriter writer = new FileWriter("batting stats.csv")) {
	    StatefulBeanToCsv<Player> beanWriter = createWriter(writer);
	    
	    beanWriter.write(players);
		isSaved = true;
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}catch (CsvDataTypeMismatchException e) {
		System.err.println(e.getMessage());
	}catch (CsvRequiredFieldEmptyException e) {
		System.err.println(e.getMessage());
	}
	


	
	return isSaved;
}

}


*/
















/*import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.acs560.cricket_analyzer.model.Player;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class PlayerRepository {

    private static List<Player> players;

    public static List<Player> getPlayers() {
        if (players == null) {
            players = initializePlayers();
        }
        return players;
    }

    private static List<Player> initializePlayers() {
    	CSVReader reader;
  //      List<Player> players = new ArrayList<>();
        try {
        	reader = new CSVReader(new FileReader("batting_stats.csv"));
            ColumnPositionMappingStrategy<Player> beanStrategy = new ColumnPositionMappingStrategy<Player>();
            beanStrategy.setType(Player.class);
            beanStrategy.setColumnMapping(new String[]{"name", "team", "matches", "innings", "notouts", "runs", "average", "strike_rate"});

            CsvToBean<Player> csvToBean = new CsvToBean<Player>();
            csvToBean.setCsvReader(reader);
            csvToBean.setMappingStrategy(beanStrategy);

            players = csvToBean.parse();
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return players;
    }

    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    
 
    public List<Player> getPlayersByTeam(String team) {
        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getTeam().equals(team)) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

	public double getRuns() {
		
		return 0;
	}

    }
    
*/