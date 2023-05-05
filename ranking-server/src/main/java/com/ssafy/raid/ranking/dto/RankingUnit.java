package com.ssafy.raid.ranking.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RankingUnit")
public class RankingUnit implements Serializable {
	
	@Column(nullable = false)
    private int uid;
	
	@Column(nullable = false)
	private String nickname;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "Ranking")
	private Ranking ranking;
	
	@Column(nullable = false)
    private int characterClassId;

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
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
		return "RankingUnit [nickname=" + nickname + ", characterClassId=" + characterClassId + "]";
	}
	
}