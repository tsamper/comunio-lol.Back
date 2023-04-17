package com.tomassamper.apilol.dto;

import java.util.List;
import java.util.Set;

import com.tomassamper.apilol.domain.LeagueEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDTO {
	private long id;
	private String name;
	private String code;
	private String LeagueType;
	private List<UserNameAndEmailDTO> users;
}
