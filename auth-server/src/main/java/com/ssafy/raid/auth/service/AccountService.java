package com.ssafy.raid.auth.service;

import org.springframework.stereotype.Service;

import com.ssafy.raid.auth.dto.Account;

@Service
public interface AccountService {
	
	public Account createAccount(Account account);
	
	public boolean checkIdDuplicated(String id);

}
