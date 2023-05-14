package com.ssafy.raid.ranking.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "Ranking")
@DynamicInsert
@NamedNativeQuery(
		name= "findAllRanking",
		query="	SELECT\r\n" + 
				"        `rank`,\r\n" + 
				"        r.rankingId `rankingId`,\r\n" + 
				"        r.mapId `mapId`,\r\n" + 
				"        r.completeTime `completeTime`,\r\n" + 
				"        r.created `created`  \r\n" + 
				"    FROM\r\n" + 
				"        (SELECT *, RANK() OVER(ORDER BY completeTime) `rank` FROM Ranking)  r\r\n" + 
				"    WHERE\r\n" + 
				"        mapId = :mapId \r\n" + 
				"        and   r.rankingId in (\r\n" + 
				"            SELECT\r\n" + 
				"                rankingId \r\n" + 
				"            from\r\n" + 
				"                RankingUnit ru \r\n" + 
				"            WHERE\r\n" + 
				"                ru.nickname LIKE CONCAT('%', :nickname, '%') \r\n" + 
				"        )  LIMIT :start, :count"
		,resultSetMapping = "findAllRanking"
)
@SqlResultSetMapping(
		name = "findAllRanking",
		entities = {
				@EntityResult(
						entityClass=com.ssafy.raid.ranking.dto.Ranking.class, 
						fields= {
							@FieldResult(name="rankingId", column="rankingId"),
							@FieldResult(name="mapId", column="mapId"),
							@FieldResult(name="completeTime", column="completeTime"),
							@FieldResult(name="created", column="created")
						}
					)
		},
		classes ={
				@ConstructorResult(
						targetClass=com.ssafy.raid.ranking.dto.Ranking.class, 
						columns={
				                @ColumnResult(name = "rank", type = Integer.class),
				                @ColumnResult(name = "rankingId", type = Integer.class),
				                @ColumnResult(name = "mapId", type = Integer.class),
				                @ColumnResult(name = "completeTime", type = Long.class),
				                @ColumnResult(name = "created", type = Date.class)
						}
					)}
)
public class Ranking {
    
	@Transient
    private int rank;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingId;
    
    @Column(nullable = false)
    private int mapId;
    
    @Column(nullable = false)
    private long completeTime;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date created;

    @OneToMany(mappedBy="rankingId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RankingUnit> rankingUnits = new ArrayList<>();
    
	public Ranking(int rank, int rankingId, int mapId, long completeTime, Date created) {
		this.rank = rank;
		this.rankingId = rankingId;
		this.mapId = mapId;
		this.completeTime = completeTime;
		this.created = created;
	}
	
	public Ranking() {}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRankingId() {
		return rankingId;
	}

	public void setRankingId(int rankingId) {
		this.rankingId = rankingId;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
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

	
    
}