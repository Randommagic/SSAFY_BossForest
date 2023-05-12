package com.ssafy.raid.auth.exception.handler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.builder.ErrorResponseBuilder;


@RestControllerAdvice
public class AccountExceptionHandler {
	
		
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception){
		return toResponseEntity(ErrorResponseBuilder.duplicatedID());
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ResponseDTO> handleSQLException(SQLException exception){
		return toResponseEntity(ErrorResponseBuilder.failedToCreate());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		return toResponseEntity(ErrorResponseBuilder.ParameterValidationFailed(exception));
	}
	
	public static ResponseEntity<ResponseDTO> toResponseEntity(ResponseDTO response){
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

}
