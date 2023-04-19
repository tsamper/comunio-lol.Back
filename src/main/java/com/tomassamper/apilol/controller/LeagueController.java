package com.tomassamper.apilol.controller;

import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomassamper.apilol.domain.League;
import com.tomassamper.apilol.domain.LeagueEnum;
import com.tomassamper.apilol.domain.LeagueUser;
import com.tomassamper.apilol.domain.LeagueUserId;
import com.tomassamper.apilol.domain.Player;
import com.tomassamper.apilol.domain.PlayerLeague;
import com.tomassamper.apilol.domain.PlayerLeagueId;
import com.tomassamper.apilol.domain.User;
import com.tomassamper.apilol.dto.LeagueDTO;
import com.tomassamper.apilol.service.LeagueService;
import com.tomassamper.apilol.service.LeagueUserService;
import com.tomassamper.apilol.service.PlayerLeagueService;
import com.tomassamper.apilol.service.PlayerService;
import com.tomassamper.apilol.service.UserService;

@RestController
public class LeagueController {
	
	private Logger logger = LoggerFactory.getLogger(LeagueController.class);	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	LeagueService leagueService;
	@Autowired
	UserService userService;
	@Autowired
	LeagueUserService leagueUserService;
	@Autowired
	PlayerLeagueService playerLeagueService;
	@Autowired
	PlayerService playerService;
	
	private LeagueDTO convertToDTO(League league) {
		return modelMapper.map(league, LeagueDTO.class);
	}
	private League convertToClass(LeagueDTO leagueDTO) {
		return modelMapper.map(leagueDTO, League.class);
	}
	
	@GetMapping("/getTypeOfLeagues")
	public ResponseEntity<LeagueEnum[]> getTypeEnum(){
		return new ResponseEntity<LeagueEnum[]>(LeagueEnum.values(), HttpStatus.OK);
	}
	
	@PostMapping("/newLeague")
	public void newLeague(@RequestBody LeagueDTO leagueDTO) {
		League league = convertToClass(leagueDTO);
		User user = userService.findByActive(true);
		LeagueUserId leagueId = new LeagueUserId(league.getId(), user.getId());
		LeagueUser leagueUser = new LeagueUser(leagueId, league, user);
		ArrayList<Player> players = playerService.findByLeagueType(league.getLeagueType());
		leagueService.add(league);
		leagueUserService.add(leagueUser);
		for (Player player : players) {
			PlayerLeagueId id = new PlayerLeagueId(player.getId(), league.getId());
			PlayerLeague playerLeague = new PlayerLeague(id, player, league, null);
			playerLeagueService.add(playerLeague);
		}
	}
	
	@GetMapping("/getLeague/{code}")
	public ResponseEntity<LeagueDTO> getLeague(@PathVariable String code) {
		League league = leagueService.findByCode(code);
		LeagueDTO leagueDTO = convertToDTO(league);
		return new ResponseEntity<LeagueDTO>(leagueDTO, HttpStatus.OK);
	}
	
	@PatchMapping("/addUserToLeague")
	public void addUserToLeague(@RequestBody League leagueProvided) {
		User user = userService.findByActive(true);
		League league = leagueService.findByCode(leagueProvided.getCode());
		LeagueUserId leagueId = new LeagueUserId(league.getId(), user.getId());
		LeagueUser leagueUser = new LeagueUser(leagueId, league, user);
		ArrayList<LeagueUser> allLeagues = leagueUserService.findAll();
		if(!allLeagues.contains(leagueUser)) {
			leagueUserService.add(leagueUser);
		}else {
			logger.info("El usuario ya se encuentra en la liga");
		}
		
	}
	
	@GetMapping("/getAllCodes")
	public ResponseEntity<ArrayList<LeagueDTO>> getAllCodes(){
		ArrayList<League> leagues = leagueService.findAll();
		ArrayList<LeagueDTO> leaguesDTO = new ArrayList<>(); 
		leagues.stream().forEach(league -> leaguesDTO.add(convertToDTO(league)));
		return new ResponseEntity<ArrayList<LeagueDTO>>(leaguesDTO,HttpStatus.OK);
	}
	
	@GetMapping("/getLeaguesFromUser")
	public ResponseEntity<ArrayList<LeagueDTO>> getPrueba(){
		User user = userService.findByActive(true);
		ArrayList<LeagueUser> leaguesUser = leagueUserService.findByUser(user);
		ArrayList<LeagueDTO> leaguesDTO = new ArrayList<>();
		leaguesUser.stream().forEach(league -> leaguesDTO.add(convertToDTO(league.getLeague())));
		return new ResponseEntity<ArrayList<LeagueDTO>>(leaguesDTO, HttpStatus.OK);
	}
}
