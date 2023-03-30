package com.tomassamper.apilol.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomassamper.apilol.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	ArrayList<User> findAll();
	User findByUsername(String username);
	User findByActive(boolean state);
	User findById(long id);
}
