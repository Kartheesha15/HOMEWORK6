package com.acs560.cricket_analyzer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.AnalysisServices;

import lombok.NoArgsConstructor;

@RestController()
@RequestMapping("/api/v1/analysis")
@NoArgsConstructor
public class AnalysisController {
	
	@Autowired
	private AnalysisServices analysisServices;
	
	public AnalysisController(AnalysisServices analysisServices) {
		this.analysisServices = analysisServices;
	}

	@GetMapping("/average/runs/{team}")
	public double getAverageRuns(@PathVariable String team) {
		return analysisServices.calculateAverageRuns(team );
	}
	
	@GetMapping("/average/strikeRate/{team}")
	public double getAverageStrikeRate(@PathVariable String team) {
		return analysisServices.calculateAverageStrikeRate(team);
	}
	
	@GetMapping("/average/NotOuts/{team}")
	public double getAverageNotOuts(@PathVariable String team) {
		return analysisServices.calculateAverageNotOuts(team );
	}
	
	@GetMapping("/average/Innings/{team}")
	public double getAverageInningsbyTeam(@PathVariable String team) {
		return analysisServices.calculateAverageInningsbyTeam(team );
	}
	
	@GetMapping("/average/Matches/{team}")
	public double getAverageMatchesbyTeam(@PathVariable String team) {
		return analysisServices.calculateAverageMatchesbyTeam(team );
	}
	
//	@GetMapping("/average/Compare/{team1}/{team2}")
//	public String getCompareRuns(@PathVariable String team1, @PathVariable String team2) {
//		return analysisServices.CompareRuns(team1, team2 );
//	}
	
}




















/*import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.model.Player;

import lombok.NoArgsConstructor;
@RestController
@RequestMapping("/analysis")
@NoArgsConstructor
public class AnalysisController{

	public AnalysisServices analysisServices;

    @GetMapping("/analysis/average-runs")
    public double getAverageRuns(String name) {
        return analysisServices.getAverageRuns(name);
    }

    @GetMapping("/analysis/average-strike-rate")
    public double getAverageStrikeRate(String name) {
        return analysisServices.getAverageStrikeRate(name);
    }

    @GetMapping("/analysis/highest-average")
    public double getHighestAverage() {
        return analysisServices.getHighestAverage();
    }
    @GetMapping("/analysis/highest-strike-rate")
    public double getHighestStrikeRate(String team) {
        return analysisServices.getHighestStrikeRate(team);
    }

    @GetMapping("/analysis/top-scorers/{n}")
    public List<Player> getTopScorers(@PathVariable int n) {
        return analysisServices.getTopScorers(n);
    }

    @GetMapping("/analysis/top-strikers/{n}")
    public List<Player> getTopStrikers(@PathVariable int n) {
        return analysisServices.getTopStrikers(n);
    }

    @GetMapping("/analysis/team-average-runs/{team}")
    public double getTeamAverageRuns(@PathVariable String team) {
    	return analysisServices.getTeamAverageRuns(team);
    }

    @GetMapping("/analysis/team-average-strike-rate/{team}")
    public double getTeamAverageStrikeRate(@PathVariable String team) {
        return analysisServices.getTeamAverageStrikeRate(team);
    }

}
*/


/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;

import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/v1/bat")
@NoArgsConstructor
public class PlayersController {
    
    public PlayerServices playerServices;
    
    @Autowired
    public PlayersController(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }
    
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerServices.getAllPlayers();
    }
    
    @GetMapping("/players/{name}")
    public Player getPlayerByName(@PathVariable String name) {
        return playerServices.getPlayerByName(name);
    }
    
    @GetMapping("/players/team/{team}")
    public List<Player> getPlayersByTeam(@PathVariable String team) {
        return playerServices.getPlayersByTeam(team);
    }
}*/
