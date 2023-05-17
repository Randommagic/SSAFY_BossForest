package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.ResponseDTO;

public class AccountResponseBuilder {
	
	static ResponseDTO success = new ResponseDTO(1, "Account has been created.", HttpStatus.OK);
	
	public static ResponseDTO success() {
		return success;
	}
	
}
