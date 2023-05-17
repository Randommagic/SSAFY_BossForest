package com.ssafy.raid.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.raid.ranking.dto.Ranking;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Integer>{

	@Query("select r from Ranking r join fetch r.rankingUnits order by r.completeTime")
	List<Ranking> findAll();
	
	@Query(name="findAllRanking")
	List<Ranking> findAllRanking(
			@Param(value="mapId") int mapId, 
			@Param(value="nickname") String nickname, 
			@Param(value="start") int start, 
			@Param(value="count") int count
		);
}
