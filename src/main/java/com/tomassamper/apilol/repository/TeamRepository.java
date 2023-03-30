package com.tomassamper.apilol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

}
