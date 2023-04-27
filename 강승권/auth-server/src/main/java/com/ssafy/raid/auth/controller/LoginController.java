package com.ssafy.raid.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.service.AccountService;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(HttpSession session, LoginRequestDTO loginRequestDTO){
		ResponseDTO responseDTO = accountService.login(loginRequestDTO, session);
		return ResponseEntity.status(responseDTO.getHttpStatus()).body(responseDTO);
	}
	

}
