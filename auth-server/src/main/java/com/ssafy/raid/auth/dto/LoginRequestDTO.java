package com.ssafy.raid.auth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequestDTO extends RequestDTO{
	
	@NotBlank
	@NotNull
	private String username;
	
	@NotBlank
	@NotNull
	private String password;

	public LoginRequestDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginRequestDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDTO [username=" + username + ", password=" + password + "]";
	}
	
	

}
