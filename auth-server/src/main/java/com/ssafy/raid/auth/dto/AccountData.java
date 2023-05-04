package com.ssafy.raid.auth.dto;

public class AccountData {

	String Nickname;
	
	String ClientKey;

	public AccountData(String nickname, String clientKey) {
		super();
		Nickname = nickname;
		ClientKey = clientKey;
	}
	
	public AccountData() {
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public String getClientKey() {
		return ClientKey;
	}

	public void setClientKey(String clientKey) {
		ClientKey = clientKey;
	}
	
}
