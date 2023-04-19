package com.tomassamper.apilol.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tomassamper.apilol.domain.LeagueUser;
import com.tomassamper.apilol.domain.User;
import com.tomassamper.apilol.repository.LeagueUserRepository;
import com.tomassamper.apilol.service.LeagueUserService;

@Service
public class LeagueUserServiceImpl implements LeagueUserService {
	
	@Autowired
	LeagueUserRepository leagueUserRepository;

	@Override
	public ArrayList<LeagueUser> findByUser(User user) {
		return leagueUserRepository.findByUser(user);
	}

	@Override
	public void add(LeagueUser leagueUser) {
		leagueUserRepository.save(leagueUser);
		
	}

	@Override
	public ArrayList<LeagueUser> findAll() {
		return leagueUserRepository.findAll();
	}

}
