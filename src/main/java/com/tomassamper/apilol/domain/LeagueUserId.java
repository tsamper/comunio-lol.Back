package com.tomassamper.apilol.domain;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LeagueUserId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long leagueId;
	private long userId;
}
