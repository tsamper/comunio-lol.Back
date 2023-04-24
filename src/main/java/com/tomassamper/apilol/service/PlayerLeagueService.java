package com.tomassamper.apilol.service;

import java.util.ArrayList;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.domain.Player;
import com.tomassamper.apilol.domain.PlayerLeague;
import com.tomassamper.apilol.domain.User;

public interface PlayerLeagueService {
	public void add(PlayerLeague playerLeague);
	public ArrayList<PlayerLeague> findByOwner(User user);
	public ArrayList<PlayerLeague> findByLeague(League league);
	public PlayerLeague findByLeagueAndPlayer(League league, Player player);
	public ArrayList<PlayerLeague> findByLeagueAndOwner(League league, User user);
}
