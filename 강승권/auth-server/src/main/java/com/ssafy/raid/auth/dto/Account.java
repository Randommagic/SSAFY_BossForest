package com.ssafy.raid.auth.dto;

import com.ssafy.raid.auth.service.util.BcryptUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(length = 72, nullable = false)
    private String password;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 32, nullable = false)
    private String nickname;
    
    public void setPassword(String password) {
        this.password = BcryptUtils.bcrypt(password);
    }

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
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

	public String getPassword() {
		return password;
	}
    
    
}