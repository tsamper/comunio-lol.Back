package com.tomassamper.apilol.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "player_league")
@Table(name = "player_league")
public class PlayerLeague {
	
	@EmbeddedId
	private PlayerLeagueId id;
	
	@ManyToOne
	@MapsId("playerId")
	private Player player;
	
	@ManyToOne
	@MapsId("leagueId")
	private League league;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner; 
}
