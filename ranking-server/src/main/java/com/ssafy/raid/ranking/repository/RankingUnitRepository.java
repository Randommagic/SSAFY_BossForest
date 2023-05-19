package com.ssafy.raid.ranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssafy.raid.ranking.dto.RankingUnit;
import com.ssafy.raid.ranking.dto.RankingUnitId;

public interface RankingUnitRepository extends CrudRepository<RankingUnit, RankingUnitId>{
	
	@Query("SELECT ru.id FROM RankingUnit ru WHERE ru.nickname LIKE '%:nickname%'")
	List<Integer> findAllIdByNickname(String nickname);
	
}
