package com.tomassamper.apilol.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomassamper.apilol.domain.LeagueEnum;
import com.tomassamper.apilol.domain.Player;
import com.tomassamper.apilol.repository.PlayerRepository;
import com.tomassamper.apilol.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public ArrayList<Player> findByRole(String role) {
		return playerRepository.findByRole(role);
	}

	@Override
	public ArrayList<Player> findByLeagueType(LeagueEnum legaue) {
		return playerRepository.findByLeague(legaue);
	}

	@Override
	public Player findByUsername(String username) {
		return playerRepository.findByUsername(username);

	}

}
