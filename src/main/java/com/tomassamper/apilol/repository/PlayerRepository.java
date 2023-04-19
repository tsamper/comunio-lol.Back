package com.tomassamper.apilol.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.LeagueEnum;
import com.tomassamper.apilol.domain.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	ArrayList<Player> findByRole(String role);
	ArrayList<Player> findByLeague(LeagueEnum league);
}
