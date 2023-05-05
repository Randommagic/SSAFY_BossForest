package com.ssafy.raid.ranking.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "Ranking")
@DynamicInsert
public class Ranking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingId;
    
    @Column(nullable = false)
    private long completeTime;
    
    @Column
    private Date created;
    
    @Column(nullable = false)
    private int mapId;

    @OneToMany(mappedBy="rankingId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RankingUnit> rankingUnits = new ArrayList<>();
    
	public int getRankingId() {
		return rankingId;
	}

	public void setRankingId(int rankingId) {
		this.rankingId = rankingId;
	}

	public long getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(long completeTime) {
		this.completeTime = completeTime;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<RankingUnit> getRankingUnits() {
		return rankingUnits;
	}

	public void setRankingUnits(List<RankingUnit> rankingUnits) {
		this.rankingUnits = rankingUnits;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	@Override
	public String toString() {
		return "Ranking [rankingId=" + rankingId + ", completeTime=" + completeTime + ", created=" + created
				+ ", mapId=" + mapId + ", rankingUnits=" + rankingUnits + "]";
	}
    
}