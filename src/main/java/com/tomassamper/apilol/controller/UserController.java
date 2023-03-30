package com.tomassamper.apilol.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomassamper.apilol.domain.User;
import com.tomassamper.apilol.dto.UserDTO;
import com.tomassamper.apilol.dto.UserNameAndEmailDTO;
import com.tomassamper.apilol.security.JwtRequest;
import com.tomassamper.apilol.security.JwtResponse;
import com.tomassamper.apilol.security.JwtTokenUtil;
import com.tomassamper.apilol.service.UserService;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private UserDTO convertToDTO(User u) {
		return modelMapper.map(u, UserDTO.class);
	}
	private UserNameAndEmailDTO convertNameAndEmailToDTO(User u) {
		return modelMapper.map(u, UserNameAndEmailDTO.class);
	}
	private User convertToClass(UserDTO u) {
		return modelMapper.map(u, User.class);
	}
	
	
	@GetMapping("/getAllUsersNameAndEmail")
	public ResponseEntity<ArrayList<UserNameAndEmailDTO>> getAllUsersNameAndEmail(){
		ArrayList<User> users = userService.findAll();
		ArrayList<UserNameAndEmailDTO> usersDTO = new ArrayList<>();
		users.stream().forEach(u -> usersDTO.add(convertNameAndEmailToDTO(u)));
		return new ResponseEntity<ArrayList<UserNameAndEmailDTO>>(usersDTO, HttpStatus.OK);
		
	}

	
	@PostMapping("/register")
	public void addUser(@RequestBody UserDTO userDTO, BindingResult bResult) {
		User user = convertToClass(userDTO);
		userService.add(user);
	}
	
	@PostMapping(value = "/login", consumes = "application/json", produces="application/json")
	public ResponseEntity<?> login(@RequestBody JwtRequest authRequest) throws Exception{
		logger.info("Inicio sesion");
		authenticate(authRequest.getUsername(), authRequest.getPassword());
		User user = userService.findByUsername(authRequest.getUsername());
		userService.modifyActive(user.getId(), true);
		final String token = jwtTokenUtil.generateToken(authRequest.getUsername());
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@CrossOrigin
	@GetMapping("/logoout")
	public  ResponseEntity<String> logoout(){
		User user = userService.findByActive(true);
		userService.modifyActive(user.getId(), false);
		return new ResponseEntity<String>("Logout exitoso", HttpStatus.OK);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try { 
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e){
			throw new Exception("User disabled", e);
		}catch (BadCredentialsException bce) {
			throw new Exception("Invalid credentials", bce);
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
