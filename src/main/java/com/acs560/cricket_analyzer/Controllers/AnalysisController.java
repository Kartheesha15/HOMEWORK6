
//updated

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
	

	private AnalysisServices analysisServices;
	
	@Autowired
	public AnalysisController(AnalysisServices analysisServices) {
		this.analysisServices = analysisServices;
	}

	@GetMapping("/average/runs/{matches}")
	public double getAverage(@PathVariable int matches) {
	    System.out.println("Received request for matches: " + matches);
	    double average = analysisServices.calculateAverage(matches);
	    System.out.println("Calculated average: " + average);
	    return average;
	}

	
	@GetMapping("/average/{matches}/{id}")
	public double getAverageStrikeRate(@PathVariable int matches, @PathVariable Long companyId) {
		return analysisServices.calculateAverageRuns(matches, companyId);
	}
	
	@GetMapping("/test")
	public String testEndpoint() {
	    return "AnalysisController is working!";
	}

	
	

}




















