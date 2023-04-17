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
public class CountryDTO {
	
	private long id;
	private String name;
	private String flag;
	private List<PlayerDTO> players;
	private List<TeamDTO> teams;
}
