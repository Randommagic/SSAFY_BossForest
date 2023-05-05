package com.ssafy.raid.ranking.service;

import com.ssafy.raid.ranking.dto.Ranking;

public interface RankingService {
	
	public Ranking insertRanking(Ranking ranking);
	
	public Iterable<Ranking> getAllRanking();
	
}
