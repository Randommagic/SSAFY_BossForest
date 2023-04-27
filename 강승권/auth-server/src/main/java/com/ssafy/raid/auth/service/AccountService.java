package com.ssafy.raid.auth.service;

import com.ssafy.raid.auth.dto.LoginRequestDTO;
import com.ssafy.raid.auth.dto.ResponseDTO;

import jakarta.servlet.http.HttpSession;

public interface AccountService {
	ResponseDTO login(LoginRequestDTO loginRequest, HttpSession session);
}