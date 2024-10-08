

package com.acs560.cricket_analyzer.Services;

import org.springframework.stereotype.Service;

@Service
public interface AnalysisServices {
	
	double calculateAverageRuns(String team);
	
	double calculateAverageStrikeRate(String team);

	double calculateAverageNotOuts(String team);
	
	double calculateAverageInningsbyTeam(String team);
	
	double calculateAverageMatchesbyTeam(String team);
	
//	String CompareRuns(String team1, String team2);

}
