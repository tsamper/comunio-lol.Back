package com.tomassamper.apilol.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity( name = "league_user")
@Table( name = "league_user")
public class LeagueUser {
	
	@EmbeddedId
	private LeagueUserId id;
	
	@ManyToOne
	@MapsId("leagueId")
	private League league;
	
	@ManyToOne
	@MapsId("userId")
	private User user;
}
