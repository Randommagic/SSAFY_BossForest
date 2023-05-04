package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.AccountData;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;

public class ResponseBuilder {
	
	static ResponseDTO incomplete = new ResponseDTO(ResultCode.AuthIsIncomplete, null, "Authentication incomplete.", HttpStatus.UNAUTHORIZED, null);
	
	static ResponseDTO failed = new ResponseDTO(ResultCode.Failed, null, "Authentication failed.", HttpStatus.FORBIDDEN, null);
	
	static ResponseDTO invalidParam = new ResponseDTO(ResultCode.InvalidParameters, null, "Invalid parameters.", HttpStatus.BAD_REQUEST, null);
	
	static final String completeMessage = "Authentication complete.";
	
	public static ResponseDTO AuthIsIncomplete() {
		return incomplete;
	}
	
	public static ResponseDTO AuthComplete(Account account, String sessionID) {
		return new ResponseDTO(ResultCode.AuthIsComplete, account.getId(), completeMessage, HttpStatus.OK, new AccountData(account.getUid(), account.getId(), account.getNickname(), sessionID));
	}
	
	public static ResponseDTO AuthFailed() {
		return failed;
	}
	
	public static ResponseDTO InvalidParameters() {
		return invalidParam;
	}

}
