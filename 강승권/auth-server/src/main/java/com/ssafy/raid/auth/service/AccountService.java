package com.ssafy.raid.auth.service;

import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;

import javax.servlet.http.HttpSession;

public interface AccountService {
	ResponseDTO login(LoginRequestDTO loginRequest, HttpSession session);
	boolean logout(HttpSession session);
}