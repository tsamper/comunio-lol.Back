package com.tomassamper.apilol.service;

import java.util.ArrayList;
import com.tomassamper.apilol.domain.LeagueUser;
import com.tomassamper.apilol.domain.User;

public interface LeagueUserService {
	public ArrayList<LeagueUser> findByUser(User user);
	public void add(LeagueUser leagueUser);
	public ArrayList<LeagueUser> findAll();
}
