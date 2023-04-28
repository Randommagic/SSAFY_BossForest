package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;

public class ResponseBuilder {
	
	static ResponseDTO incomplete = new ResponseDTO(ResultCode.AuthIsIncomplete, null, null, "Authentication incomplete.", HttpStatus.UNAUTHORIZED);
	
	static ResponseDTO failed = new ResponseDTO(ResultCode.Failed, null, null, "Authentication failed.", HttpStatus.FORBIDDEN);
	
	static ResponseDTO invalidParam = new ResponseDTO(ResultCode.InvalidParameters, null, null, "Invalid parameters.", HttpStatus.BAD_REQUEST);
	
	static final String completeMessage = "Authentication complete.";
	
	public static ResponseDTO AuthIsIncomplete() {
		return incomplete;
	}
	
	public static ResponseDTO AuthComplete(Account account) {
		return new ResponseDTO(ResultCode.AuthIsComplete, account.getId(), account.getNickname(), completeMessage, HttpStatus.OK);
	}
	
	public static ResponseDTO AuthFailed() {
		return failed;
	}
	
	public static ResponseDTO InvalidParameters() {
		return invalidParam;
	}

}
