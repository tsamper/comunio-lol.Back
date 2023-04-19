package com.tomassamper.apilol.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.domain.LeagueEnum;
import com.tomassamper.apilol.domain.Player;
import com.tomassamper.apilol.domain.PlayerLeague;
import com.tomassamper.apilol.dto.PlayerDTO;
import com.tomassamper.apilol.service.LeagueService;
import com.tomassamper.apilol.service.PlayerLeagueService;
import com.tomassamper.apilol.service.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	@Autowired
	PlayerLeagueService playerLeagueService;
	@Autowired
	LeagueService leagueService;
	@Autowired
	ModelMapper modelMapper;
	
	private PlayerDTO convertToDTO(Player player) {
		return modelMapper.map(player, PlayerDTO.class);
	}
	
	@GetMapping("/getPlayersByRole/{role}")
	public ResponseEntity<ArrayList<PlayerDTO>> findByRole(@PathVariable String role){
		ArrayList<Player> players = playerService.findByRole(role);
		ArrayList<PlayerDTO> playersDTO = new ArrayList<>();
		players.stream().forEach(player -> playersDTO.add(convertToDTO(player)));
		return new ResponseEntity<ArrayList<PlayerDTO>>(playersDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getPlayersByLeagueType/{type}")
	public ResponseEntity<ArrayList<PlayerDTO>> findByLeagueType(@PathVariable LeagueEnum type){
		ArrayList<Player> players = playerService.findByLeagueType(type);
		ArrayList<PlayerDTO> playersDTO = new ArrayList<>();
		players.stream().forEach(player -> playersDTO.add(convertToDTO(player)));
		return new ResponseEntity<ArrayList<PlayerDTO>>(playersDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getPlayersWithoutOwner/{code}")
	public ResponseEntity<ArrayList<PlayerDTO>> getPlayersWithoutOwner(@PathVariable String code) {
		League league = leagueService.findByCode(code);
		ArrayList<PlayerLeague> playersLeague = playerLeagueService.findByLeague(league);
		ArrayList<PlayerLeague> playersWithoutOwner = new ArrayList<>();
		for (PlayerLeague player : playersLeague) {
			if (player.getOwner() == null ) {
				playersWithoutOwner.add(player);
			}
		}
		ArrayList<Player> players = new ArrayList<>();
		for (PlayerLeague player : playersWithoutOwner) {
			players.add(player.getPlayer());
		}
		ArrayList<PlayerDTO> playersDTO = new ArrayList<>();
		players.stream().forEach(player -> playersDTO.add(convertToDTO(player)));
		return new ResponseEntity<ArrayList<PlayerDTO>>(playersDTO, HttpStatus.OK);
	}
	
	@PostMapping("/buyPlayer")
	public void buyAPlayer(@RequestBody PlayerDTO id) {
		System.out.println(id);
	}
}
