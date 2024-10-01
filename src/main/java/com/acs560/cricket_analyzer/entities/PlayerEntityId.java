package com.acs560.cricket_analyzer.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerEntityId implements Serializable {

	private static final long serialVersionUID = 7252327203288421943L;
    private String name;
	private String team;
//	private int matches;
//	private int innings;
//  private int notouts;
//	private int runs;
//	private double average;
//	private double strikeRate;
	 public PlayerEntityId(String name, String team) {
	        this.name = name;
	        this.team = team;
	    }
 
}
