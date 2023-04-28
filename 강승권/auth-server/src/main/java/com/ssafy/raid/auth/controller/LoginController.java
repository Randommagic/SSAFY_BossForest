package com.ssafy.raid.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.service.AccountService;

@RestController
public class LoginController {
	
	/*
	@Autowired
	AccountService accountService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(HttpSession session, LoginRequestDTO loginRequestDTO){
		System.out.println("Login 시도");
		ResponseDTO responseDTO = accountService.login(loginRequestDTO, session);
		return ResponseEntity.status(responseDTO.getHttpStatus()).body(responseDTO);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		System.out.println("Logout 시도");
		if(accountService.logout(session)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}
	*/
}
