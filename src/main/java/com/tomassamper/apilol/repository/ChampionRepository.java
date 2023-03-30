package com.tomassamper.apilol.repository;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.Champion;

@Repository
public interface ChampionRepository extends CrudRepository<Champion, Long> {
	ArrayList<Champion> findAll();
}
