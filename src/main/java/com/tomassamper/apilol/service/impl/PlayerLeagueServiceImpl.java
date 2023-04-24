package com.tomassamper.apilol.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.domain.Player;
import com.tomassamper.apilol.domain.PlayerLeague;
import com.tomassamper.apilol.domain.User;
import com.tomassamper.apilol.repository.PlayerLeagueRepository;
import com.tomassamper.apilol.service.PlayerLeagueService;

@Service
public class PlayerLeagueServiceImpl implements PlayerLeagueService {

	@Autowired
	PlayerLeagueRepository playerLeagueRepository;
	
	@Override
	public void add(PlayerLeague playerLeague) {
		playerLeagueRepository.save(playerLeague);
	}

	@Override
	public ArrayList<PlayerLeague> findByOwner(User user) {
		return playerLeagueRepository.findByOwner(user);
	}

	@Override
	public ArrayList<PlayerLeague> findByLeague(League league) {
		return playerLeagueRepository.findByLeague(league);
	}

	@Override
	public PlayerLeague findByLeagueAndPlayer(League league, Player player) {
		return playerLeagueRepository.findByLeagueAndPlayer(league, player);
	}

	@Override
	public ArrayList<PlayerLeague> findByLeagueAndOwner(League league, User user) {
		return playerLeagueRepository.findByLeagueAndOwner(league, user);
	}

}
