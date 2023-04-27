package com.ssafy.raid.auth.dto.builder;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;

public class ResponseBuilder {
	
	static ResponseDTO incomplete = new ResponseDTO(ResultCode.AuthIsIncomplete, null, null, "Authentication incomplete.", 401);
	
	static ResponseDTO failed = new ResponseDTO(ResultCode.Failed, null, null, "Authentication failed.", 403);
	
	static ResponseDTO invalidParam = new ResponseDTO(ResultCode.InvalidParameters, null, null, "Invalid parameters.", 400);
	
	static final String completeMessage = "Authentication complete.";
	
	public static ResponseDTO AuthIsIncomplete() {
		return incomplete;
	}
	
	public static ResponseDTO AuthComplete(Account account) {
		return new ResponseDTO(ResultCode.AuthIsComplete, account.getId(), account.getNickname(), completeMessage, 200);
	}
	
	public static ResponseDTO AuthFailed() {
		return failed;
	}
	
	public static ResponseDTO InvalidParameters() {
		return invalidParam;
	}

}
