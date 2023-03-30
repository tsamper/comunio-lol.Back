package com.tomassamper.apilol.service;

import java.util.ArrayList;

import com.tomassamper.apilol.domain.User;

public interface UserService {
	public void add(User user);
	public ArrayList<User> findAll();
	public User findByUsername(String username);
	public User findByActive(boolean state);
	public boolean modifyActive(long id, boolean state);
}
