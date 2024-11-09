package com.acs560.cricket_analyzer.entities;

import java.io.Serializable;

import com.acs560.cricket_analyzer.model.Player;

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
    

    private Long countryId;

    
    public PlayerEntityId(Player player) {
    	this.name = player.getName();
    	this.countryId = player.getCountryId();
    }

}
