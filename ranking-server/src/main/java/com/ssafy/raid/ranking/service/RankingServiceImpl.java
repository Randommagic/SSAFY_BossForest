package com.ssafy.raid.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.raid.ranking.dto.Ranking;
import com.ssafy.raid.ranking.repository.RankingRepository;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	RankingRepository rankingRepository;
	
	@Override
	public Ranking insertRanking(Ranking ranking) {
		System.out.println(ranking);
		return rankingRepository.save(ranking);
	}

	@Override
	public Iterable<Ranking> getAllRanking() {
		return rankingRepository.findAll();
	}

}
