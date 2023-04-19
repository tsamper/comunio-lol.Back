package com.tomassamper.apilol.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.domain.PlayerLeague;
import com.tomassamper.apilol.domain.User;

@Repository
public interface PlayerLeagueRepository extends CrudRepository<PlayerLeague, Long>{
	ArrayList<PlayerLeague> findByOwner(User user);
	ArrayList<PlayerLeague> findByLeague(League league);
}
