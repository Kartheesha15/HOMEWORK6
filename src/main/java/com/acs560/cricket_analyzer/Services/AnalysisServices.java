

package com.acs560.cricket_analyzer.Services;

import org.springframework.stereotype.Service;

@Service
public interface AnalysisServices {
	
	double calculateAverage(int matches);
	
	double calculateAverageRuns(int matches, Long companyId);
	
//	double calculateAverageStrikeRate(int companyId);

//	double calculateAverageNotOuts(int companyId);
	
//	double calculateAverageInningsbyTeam(int companyId);
	
//	double calculateAverageMatchesbyTeam(int companyId);
	
	
	
//	String CompareRuns(String team1, String team2);

}
