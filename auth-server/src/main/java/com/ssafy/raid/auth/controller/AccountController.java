package com.ssafy.raid.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.builder.AccountResponseBuilder;
import com.ssafy.raid.auth.dto.builder.CheckIdDuplicationResponseBuilder;
import com.ssafy.raid.auth.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account")
	public ResponseEntity<ResponseDTO> createAccount(@RequestBody Account account){
		accountService.createAccount(account);
		return ResponseEntity.ok(AccountResponseBuilder.success());
	}
	
	@GetMapping("/account/id")
	public ResponseEntity<ResponseDTO> checkIdDuplication(String id){
		if(accountService.checkIdDuplicated(id)) {
			return ResponseEntity.ok(CheckIdDuplicationResponseBuilder.duplicated());
		}else {
			return ResponseEntity.ok(CheckIdDuplicationResponseBuilder.notDuplicated());
		}
	}
	
}
