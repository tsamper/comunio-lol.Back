package com.tomassamper.apilol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
