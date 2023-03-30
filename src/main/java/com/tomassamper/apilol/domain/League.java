package com.tomassamper.apilol.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "league")
@Table(name = "leagues")
public class League {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column
	private String name;
	
	@Column
	private LeagueEnum type;
	
	@ManyToMany
	@JoinTable(name="user_league", joinColumns = @JoinColumn(name="league_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<User> users;
	
}
