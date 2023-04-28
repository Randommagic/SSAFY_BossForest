package com.ssafy.raid.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;

import com.ssafy.raid.auth.dto.Account;
import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;
import com.ssafy.raid.auth.dto.ResultCode;
import com.ssafy.raid.auth.repository.AccountRepository;
import com.ssafy.raid.auth.service.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	
	@InjectMocks
	AccountServiceImpl accountService;
	
	HttpSession session;
	
	@Mock
	AccountRepository accountRepository;
	
	@BeforeEach
	public void injectSession() {
		session = new MockHttpSession();
	}
	
	@Test
	public void loginComplete() {
		// given
		Account account = new Account();
		account.setId("test");
		account.setPassword("1234");
		account.setNickname("testman123");
		account.setUid(1);
		
		when(accountRepository.findById("test")).thenReturn(Optional.of(account));
		
		
		LoginRequestDTO request = new LoginRequestDTO("test", "1234");
		ResponseDTO response = accountService.login(request, session);
		assertEquals(response.getResultCode(), ResultCode.AuthIsComplete);
		assertEquals(response.getUserId(), "test");
		assertEquals(response.getNickName(), "testman123");
		assertNotNull(session.getAttribute("account"));
		assertTrue(session.getAttribute("account") instanceof Account);
		assertEquals(((Account)session.getAttribute("account")).getId(), "test");
		assertNotEquals(((Account)session.getAttribute("account")).getPassword(), "1234");
		assertEquals(((Account)session.getAttribute("account")).getNickname(), "testman123");
		assertNotNull(((Account)session.getAttribute("account")).getUid());
		
		assertTrue(accountService.logout(session));
	}
	
	@Test
	public void loginInComplete() {
		// given
		Account account = new Account();
		account.setId("test");
		account.setPassword("1234");
		account.setNickname("testman123");
		account.setUid(1);
		
		when(accountRepository.findById("thereisnoid")).thenReturn(Optional.empty());
		
		
		LoginRequestDTO request = new LoginRequestDTO("thereisnoid", "7777");
		ResponseDTO response = accountService.login(request, session);
		assertEquals(response.getResultCode(), ResultCode.AuthIsIncomplete);
		assertNull(response.getUserId());
		assertNull(response.getNickName());
		assertNull(session.getAttribute("account"));
		
		assertFalse(accountService.logout(session));
	}
	
	@Test
	public void logoutWithoutLogin() {
		assertFalse(accountService.logout(session));
	}

}
