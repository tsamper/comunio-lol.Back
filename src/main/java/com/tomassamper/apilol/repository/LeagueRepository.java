package com.tomassamper.apilol.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.League;

@Repository
public interface LeagueRepository extends CrudRepository<League, Long> {
	ArrayList<League> findAll();
	League findByCode(String code);
}
