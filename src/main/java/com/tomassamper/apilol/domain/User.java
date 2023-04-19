package com.tomassamper.apilol.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String firstSurname;
	
	@Column
	private String secondSurname;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private int money;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;
	
	@Column 
	private LocalDateTime lastLogin;
	
	@Column 
	private boolean active;

	@ManyToMany
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", username=" + username + ", password=" + password + ", email=" + email + ", money="
				+ money + ", creationDate=" + creationDate + ", lastLogin=" + lastLogin + ", active=" + active + "]";
	}
	
	
}
