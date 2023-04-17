package com.tomassamper.apilol.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.repository.LeagueRepository;
import com.tomassamper.apilol.service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	LeagueRepository leagueRepository;

	@Override
	public void add(League league) {
		leagueRepository.save(league);
	}

	@Override
	public ArrayList<League> findAll() {
		return leagueRepository.findAll();
	}

	@Override
	public League findByCode(String code) {
		return leagueRepository.findByCode(code);
	}

}
