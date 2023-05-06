package com.ssafy.raid.ranking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.raid.ranking.dto.Ranking;
import com.ssafy.raid.ranking.dto.RankingUnit;
import com.ssafy.raid.ranking.repository.RankingRepository;
import com.ssafy.raid.ranking.repository.RankingUnitRepository;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	RankingRepository rankingRepository;
	
	@Autowired
	RankingUnitRepository rankingUnitRepository;
	
	@Override
	@Transactional
	public Ranking insertRanking(Ranking ranking) {
		ranking = rankingRepository.save(ranking);
		for(RankingUnit ru : ranking.getRankingUnits()) {
			ru.setRankingId(ranking.getRankingId());
		}
		rankingUnitRepository.saveAll(ranking.getRankingUnits());
		return ranking;
	}

	@Override
	public List<Ranking> getAllRanking() {
		return rankingRepository.findAll();
	}

}
