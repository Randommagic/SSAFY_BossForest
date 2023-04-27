package com.ssafy.raid.auth.dto;

public class LoginRequestDTO extends RequestDTO{
	
	private String id;
	
	private String password;

	public LoginRequestDTO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public LoginRequestDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
