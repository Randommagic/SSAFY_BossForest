package com.ssafy.raid.ranking.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "RankingUnit")
@IdClass(RankingUnitId.class)
public class RankingUnit implements Serializable, Persistable<Integer> {
	
	@Id
	@Column(nullable = false)
    private int uid;
	
	@Id
	@Column(nullable = false)
    private int rankingId;
	
	@Column(nullable = false)
    private int characterClassId;
	
	@Column(nullable = false)
	private String nickname;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRankingId() {
		return rankingId;
	}

	public void setRankingId(int rankingId) {
		this.rankingId = rankingId;
	}

	public int getCharacterClassId() {
		return characterClassId;
	}

	public void setCharacterClassId(int characterClassId) {
		this.characterClassId = characterClassId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rankingId;
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankingUnit other = (RankingUnit) obj;
		if (rankingId != other.rankingId)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public Integer getId() {
		return rankingId;
	}

	@Override
	public boolean isNew() {
		return true;
	}

	
}