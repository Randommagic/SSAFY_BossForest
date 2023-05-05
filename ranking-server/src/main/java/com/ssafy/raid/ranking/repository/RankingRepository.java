package com.ssafy.raid.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.raid.ranking.dto.Ranking;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Integer>{

	@Query("select r from Ranking r join fetch r.rankingUnits")
	List<Ranking> findAll();
	
}
