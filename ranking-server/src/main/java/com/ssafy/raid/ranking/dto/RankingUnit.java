package com.ssafy.raid.ranking.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "RankingUnit")
public class RankingUnit implements Serializable {
	
	@Id
    private int uid;
	
    @Id
    @JoinColumn(table = "ranking")
	private int rankingId;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
    private int characterClassId;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCharacterClassId() {
		return characterClassId;
	}

	public void setCharacterClassId(int characterClassId) {
		this.characterClassId = characterClassId;
	}

	@Override
	public String toString() {
		return "RankingUnit [uid=" + uid + ", nickname=" + nickname + ", characterClassId=" + characterClassId + "]";
	}
	
	
	
}