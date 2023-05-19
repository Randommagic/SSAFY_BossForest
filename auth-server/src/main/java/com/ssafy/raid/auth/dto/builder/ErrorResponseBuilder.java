package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;

public class ErrorResponseBuilder {

	static ResponseDTO duplicatedID = new ResponseDTO(ResultCode.Failed, "Account already exists.", HttpStatus.FORBIDDEN);
	
	static ResponseDTO failedToCreate = new ResponseDTO(ResultCode.Failed, "Failed to create account. check the conditions.", HttpStatus.BAD_REQUEST);

	public static ResponseDTO duplicatedID() {
		return duplicatedID;
	}
	
	public static ResponseDTO failedToCreate() {
		return failedToCreate;
	}
	
	public static ResponseDTO ParameterValidationFailed(Exception exception) {
		return new ResponseDTO(ResultCode.InvalidParameters, exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
