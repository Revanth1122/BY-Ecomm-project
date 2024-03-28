package com.blueyonder.loginservice.payload.request;

import java.util.Set;



import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupRequest {
	@NotBlank
	private String username;
	@NotBlank
	private String password1;
	
	@NotBlank
	private String password2;
	
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 10)
	private String mobile;
	
	@NotBlank
	@Size(max = 11)
	private String gender;

	private Set<String> roles;
	



}
