package com.ssafy.raid.ranking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ssafy.raid.ranking.dto.RankingUnit;
import com.ssafy.raid.ranking.dto.RankingUnitId;

public interface RankingUnitRepository extends CrudRepository<RankingUnit, RankingUnitId>{
	
}
