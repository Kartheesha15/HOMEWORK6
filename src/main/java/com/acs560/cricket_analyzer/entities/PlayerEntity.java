package com.acs560.cricket_analyzer.entities;


import com.acs560.cricket_analyzer.model.Player;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Table(name = "playersdata") 
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerEntity {

    @EmbeddedId
    private PlayerEntityId id;
    
    @ManyToOne
    @MapsId("countryId")
    private CountryEntity country;
    
    @Column
    private int matches;
    @Column
    private int innings;
    @Column
    private int notouts;
    @Column
    private int runs;
    @Column
    private double average;
    @Column
    private double strikerate;

    // Getter for ID
    public PlayerEntityId getId() {
        return id;
    }

    // Constructor to map from Player model to PlayerEntity
//    public PlayerEntity(Player player) {
//        this(new PlayerEntityId(player.getName(), 
//        		player.getCountry().getId()),
//        		new CountryEntity(player.getCountry()),
//        		player.getMatches(),
//        		player.getInnings(),
//        		player.getNotouts(),
//        		player.getRuns(),
//        		player.getAverage(),
//        		player.getStrikeRate());
//
//    }
    
    public PlayerEntity(Player player) {
        this.id = new PlayerEntityId(player.getName(), player.getCountryId());
        this.matches = player.getMatches();
        this.innings = player.getInnings();
        this.notouts = player.getNotouts();
        this.runs = player.getRuns();
        this.average = player.getAverage();
        this.strikerate = player.getStrikeRate();
    }
}










/*import com.acs560.cricket_analyzer.model.Player;

import jakarta.persistence.EmbeddedId;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Table(name = "bills")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerEntity {
	@EmbeddedId
    private PlayerEntityId id;
    
    private double runs;
 
    public PlayerEntityId getId() {
        return id;
    }
    
    public PlayerEntity(Player player) {
    	this(new PlayerEntityId(player.getName(), player.getTeam(), player.getMatches()), player.getInnings(), player.getNotouts(), player.getRuns(), player.getAverage(), player.getStrikeRate());
    }

}
*/
