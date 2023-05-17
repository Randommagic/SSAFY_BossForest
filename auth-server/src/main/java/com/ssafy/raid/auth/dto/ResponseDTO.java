package com.ssafy.raid.auth.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ResponseDTO {
	
	int ResultCode;
	
	String Message;
	
	@JsonIgnore
	transient HttpStatus httpStatus;

	public ResponseDTO(int resultCode, String message, HttpStatus httpStatus) {
		super();
		ResultCode = resultCode;
		Message = message;
		this.httpStatus = httpStatus;
	}

	public int getResultCode() {
		return ResultCode;
	}

	public void setResultCode(int resultCode) {
		ResultCode = resultCode;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
