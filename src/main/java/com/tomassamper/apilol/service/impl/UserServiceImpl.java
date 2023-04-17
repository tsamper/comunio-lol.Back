package com.tomassamper.apilol.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tomassamper.apilol.domain.Role;
import com.tomassamper.apilol.domain.User;
import com.tomassamper.apilol.repository.RoleRepository;
import com.tomassamper.apilol.repository.UserRepository;
import com.tomassamper.apilol.security.Constant;
import com.tomassamper.apilol.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void add(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setCreationDate(LocalDate.now());
		user.setActive(false);
		user.setMoney(1000000);
		Role userRole = roleRepository.findByName(Constant.USER_ROLE);
		user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
		userRepository.save(user);
	}

	@Override
	public ArrayList<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByActive(boolean state) {
		return userRepository.findByActive(state);
	}

	@Override
	public boolean modifyActive(long id, boolean state) {
		User user = userRepository.findById(id);
		user.setActive(state);
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean modifyLastLogin(long id) {
		User user = userRepository.findById(id);
		user.setLastLogin(LocalDateTime.now());
		userRepository.save(user);
		return true;
	}

}
