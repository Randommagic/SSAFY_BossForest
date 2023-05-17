package com.ssafy.raid.ranking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.raid.dto.MultiDataResponse;
import com.ssafy.raid.ranking.dto.Ranking;
import com.ssafy.raid.ranking.service.RankingService;

@RestController
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@GetMapping("/ranking")
	public ResponseEntity<MultiDataResponse<Ranking>> getAllRanking(
			@RequestParam(required=true) int mapId, 
			@RequestParam(defaultValue="") String nickname, 
			@RequestParam(defaultValue="0") int start, 
			@RequestParam(defaultValue="10") int count
		){
		List<Ranking> rankings = rankingService.getAllRanking(start, count, mapId, nickname);
		MultiDataResponse<Ranking> response = new MultiDataResponse<>(rankings.size(), rankings);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/ranking")
	public ResponseEntity<Ranking> postRanking(@RequestBody Ranking ranking){
		return ResponseEntity.ok(rankingService.insertRanking(ranking));
	}
}
