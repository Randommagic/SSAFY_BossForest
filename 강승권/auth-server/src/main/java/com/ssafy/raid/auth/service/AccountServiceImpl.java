package com.ssafy.raid.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.builder.ResponseBuilder;
import com.ssafy.raid.auth.repository.AccountRepository;
import com.ssafy.raid.auth.service.util.BcryptUtils;

import javax.servlet.http.HttpSession;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public ResponseDTO login(LoginRequestDTO loginRequest, HttpSession session) {
		
		if(loginRequest.getUsername().isBlank() || loginRequest.getPassword().isBlank()) {
			return ResponseBuilder.InvalidParameters();
		}
		

		Optional<Account> accountOptional = accountRepository.findById(loginRequest.getUsername());
		
		if(accountOptional.isEmpty()) return ResponseBuilder.AuthIsIncomplete();

		Account account = accountOptional.get();
		
		if(!BcryptUtils.match(loginRequest.getPassword(), account.getPassword())) return ResponseBuilder.AuthFailed();
		
        session.setAttribute("account", account);

        return ResponseBuilder.AuthComplete(account);
    }

	@Override
	public boolean logout(HttpSession session) {
		if(session.getAttribute("account") == null) return false;
		session.invalidate();
		return true;
	}

}
