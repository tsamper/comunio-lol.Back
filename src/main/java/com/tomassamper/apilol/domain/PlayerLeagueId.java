package com.tomassamper.apilol.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlayerLeagueId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long playerId;
	private long leagueId;
}
