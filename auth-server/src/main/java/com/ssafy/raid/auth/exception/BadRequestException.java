package com.ssafy.raid.auth.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

public class BadRequestException extends AuthenticationServiceException{

	public BadRequestException() {
		super("Invalid Parameter.");
	}

}
