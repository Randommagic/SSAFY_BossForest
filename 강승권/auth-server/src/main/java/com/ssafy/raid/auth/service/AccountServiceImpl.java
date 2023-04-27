package com.ssafy.raid.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.builder.ResponseBuilder;
import com.ssafy.raid.auth.repository.AccountRepository;
import com.ssafy.raid.auth.service.util.BcryptUtils;

import jakarta.servlet.http.HttpSession;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public ResponseDTO login(LoginRequestDTO loginRequest, HttpSession session) {
		
		if(loginRequest.getId().isBlank() || loginRequest.getPassword().isBlank()) {
			return ResponseBuilder.InvalidParameters();
		}
		

		Optional<Account> accountOptional = accountRepository.findById(loginRequest.getId());
		
		if(accountOptional.isEmpty()) return ResponseBuilder.AuthIsIncomplete();

		Account account = accountOptional.get();
		
		if(!equalPassword(account.getPassword(),loginRequest.getPassword())) return ResponseBuilder.AuthFailed();
		
        session.setAttribute("account", account);

        return ResponseBuilder.AuthComplete(account);
    }
	
	private boolean equalPassword(String source, String target) {
		return BcryptUtils.bcrypt(source).equals(target);
	}

}
