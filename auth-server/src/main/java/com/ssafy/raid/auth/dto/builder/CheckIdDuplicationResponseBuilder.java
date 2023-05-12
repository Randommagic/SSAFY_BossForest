package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.ResponseDTO;

public class CheckIdDuplicationResponseBuilder {

	static ResponseDTO duplicated = new ResponseDTO(0, "Duplicated ID.", HttpStatus.OK);
	
	static ResponseDTO notDuplicated = new ResponseDTO(1, "ID is not found.", HttpStatus.OK);
	
	public static ResponseDTO duplicated() {
		return duplicated;
	}
	
	public static ResponseDTO notDuplicated() {
		return notDuplicated;
	}
	
}
