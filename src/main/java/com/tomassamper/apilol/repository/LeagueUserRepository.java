package com.tomassamper.apilol.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tomassamper.apilol.domain.LeagueUser;
import com.tomassamper.apilol.domain.User;

@Repository
public interface LeagueUserRepository extends CrudRepository<LeagueUser, Long> {
	ArrayList<LeagueUser> findByUser(User user);
	ArrayList<LeagueUser> findAll();
}
