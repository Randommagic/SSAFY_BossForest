package com.ssafy.raid.ranking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.raid.ranking.dto.Ranking;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Integer>{

	
	
}
