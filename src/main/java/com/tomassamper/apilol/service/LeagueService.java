package com.tomassamper.apilol.service;

import java.util.ArrayList;

import com.tomassamper.apilol.domain.League;

public interface LeagueService {
	public void add(League league);
	public ArrayList<League> findAll();
	public League findByCode(String code);
}
