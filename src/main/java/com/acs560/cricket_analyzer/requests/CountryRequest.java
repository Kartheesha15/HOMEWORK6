package com.acs560.cricket_analyzer.requests;



import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryRequest {

	@NotEmpty(message="Country is required")
	private String team;
}

