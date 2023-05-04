package com.ssafy.raid.auth.dto;

public class AccountData {

	int uid;
	
	String id;
	
	String nickname;
	
	String clientKey;

	public AccountData(int uid, String id, String nickname, String clientKey) {
		super();
		this.uid = uid;
		this.id = id;
		this.nickname = nickname;
		this.clientKey = clientKey;
	}
	
	public AccountData() {
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}


}
