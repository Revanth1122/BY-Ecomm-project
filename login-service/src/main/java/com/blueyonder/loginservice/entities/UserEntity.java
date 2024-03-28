package com.blueyonder.loginservice.entities;


import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name = "user_login_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotBlank
	@Size(max = 120)
	private String username;
	@NotBlank
	@Size(max = 120)
	private String password1;
	@Transient
	private String password2;

	@Email
	@Size(max = 120)
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ecommerce_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Exclude
	private Set<Role> roles = new HashSet<>();

	public UserEntity(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password1 = password;
	}
	
}
