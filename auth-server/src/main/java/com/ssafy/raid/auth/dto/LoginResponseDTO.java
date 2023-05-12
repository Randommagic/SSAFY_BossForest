package com.ssafy.raid.auth.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class LoginResponseDTO extends ResponseDTO{
	
	String UserId;
	
	AccountData Data;

	public LoginResponseDTO(int resultCode, String userId, String message, HttpStatus httpStatus, AccountData data) {
		super(resultCode, message, httpStatus);
		this.UserId = userId;
		this.Data = data;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public AccountData getData() {
		return Data;
	}

	public void setData(AccountData data) {
		Data = data;
	}
	
	

}
