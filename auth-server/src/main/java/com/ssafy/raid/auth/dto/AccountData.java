package com.ssafy.raid.auth.dto;

public class AccountData {

	String Nickname;

	public AccountData(String nickname) {
		super();
		Nickname = nickname;
	}
	
	public AccountData() {
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	
	
}
