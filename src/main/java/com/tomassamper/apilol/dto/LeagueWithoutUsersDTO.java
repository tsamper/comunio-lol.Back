package com.tomassamper.apilol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueWithoutUsersDTO {
	private long id;
	private String name;
	private String code;
	private String LeagueType;
}
