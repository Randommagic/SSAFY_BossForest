package com.ssafy.raid.ranking.service;

import java.util.List;

import com.ssafy.raid.ranking.dto.Ranking;

public interface RankingService {
	
	public Ranking insertRanking(Ranking ranking);
	
	public List<Ranking> getAllRanking();
	
	public List<Ranking> getAllRanking(int start, int count, int mapId, String nickname);
	
}
