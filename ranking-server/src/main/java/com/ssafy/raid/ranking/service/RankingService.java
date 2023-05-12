package com.ssafy.raid.ranking.service;

import java.util.List;

import com.ssafy.raid.ranking.dto.Ranking;

public interface RankingService {
	
	public Ranking insertRanking(Ranking ranking);
	
	public List<Ranking> getAllRanking();
	
}
