package com.ssafy.raid.auth.dto.builder;

import org.springframework.http.HttpStatus;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.AccountData;
import com.ssafy.raid.auth.dto.LoginResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;

public class LoginResponseBuilder {
	
	static LoginResponseDTO incomplete = new LoginResponseDTO(ResultCode.AuthIsIncomplete, null, "Authentication incomplete.", HttpStatus.UNAUTHORIZED, null);
	
	static LoginResponseDTO failed = new LoginResponseDTO(ResultCode.Failed, null, "Authentication failed.", HttpStatus.FORBIDDEN, null);
	
	static LoginResponseDTO invalidParam = new LoginResponseDTO(ResultCode.InvalidParameters, null, "Invalid parameters.", HttpStatus.BAD_REQUEST, null);
	
	static final String completeMessage = "Authentication complete.";
	
	public static LoginResponseDTO AuthIsIncomplete() {
		return incomplete;
	}
	
	public static LoginResponseDTO AuthComplete(Account account, String sessionID) {
		return new LoginResponseDTO(ResultCode.AuthIsComplete, account.getId(), completeMessage, HttpStatus.OK, new AccountData(account.getUid(), account.getId(), account.getNickname(), sessionID));
	}
	
	public static LoginResponseDTO AuthFailed() {
		return failed;
	}
	
	public static LoginResponseDTO InvalidParameters() {
		return invalidParam;
	}

}
