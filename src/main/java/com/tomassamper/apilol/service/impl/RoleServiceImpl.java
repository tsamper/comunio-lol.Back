package com.tomassamper.apilol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomassamper.apilol.domain.Role;
import com.tomassamper.apilol.repository.RoleRepository;
import com.tomassamper.apilol.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

}
