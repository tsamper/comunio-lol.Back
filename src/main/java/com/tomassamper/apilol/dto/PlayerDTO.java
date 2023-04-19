package com.tomassamper.apilol.dto;

import com.tomassamper.apilol.domain.LeagueEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

	private long id;
	private String name;
	private String surname;
	private String username;
	private TeamDTO team;
	private int age;
	private String role;
	private int price;
	private LeagueEnum league;
	
}
