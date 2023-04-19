package com.tomassamper.apilol.service;

import java.util.ArrayList;

import com.tomassamper.apilol.domain.LeagueEnum;
import com.tomassamper.apilol.domain.Player;

public interface PlayerService {
	public ArrayList<Player> findByRole(String role);
	public ArrayList<Player> findByLeagueType(LeagueEnum legaue);
}
