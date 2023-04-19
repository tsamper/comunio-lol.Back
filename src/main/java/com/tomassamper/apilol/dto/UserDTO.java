package com.tomassamper.apilol.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String username;
	private String email;
	private int money;
	private List<LeagueWithoutUsersDTO> leagues;
	private List<PlayerDTO> players;
}
