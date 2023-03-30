package com.tomassamper.apilol.service.impl;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomassamper.apilol.domain.Champion;
import com.tomassamper.apilol.repository.ChampionRepository;
import com.tomassamper.apilol.service.ChampionService;

@Service
public class ChampionServiceImpl implements ChampionService {
	
	@Autowired
	private ChampionRepository championRepository;

	@Override
	public ArrayList<Champion> findAll() {
		return championRepository.findAll();
	}

}
