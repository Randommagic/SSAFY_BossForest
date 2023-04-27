package com.ssafy.raid.auth.dto;

public class ResponseDTO {
	
	int ResultCode;
	
	String UserId;
	
	String NickName;
	
	String Message;
	
	transient int httpStatus;

	public ResponseDTO(int resultCode, String userId, String nickName, String message, int httpStatus) {
		super();
		ResultCode = resultCode;
		UserId = userId;
		NickName = nickName;
		Message = message;
		this.httpStatus = httpStatus;
	}

	public int getResultCode() {
		return ResultCode;
	}

	public void setResultCode(int resultCode) {
		ResultCode = resultCode;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
	
	
}
