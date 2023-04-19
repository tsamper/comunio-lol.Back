package com.tomassamper.apilol.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "player")
@Table(name = "players")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column 
	private String surname;
	
	@Column
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	@Column
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country nacionality;

	@Column 
	private String role;
	
	@Column 
	private int price;
	
	@Column
	private LeagueEnum league;
	
}
