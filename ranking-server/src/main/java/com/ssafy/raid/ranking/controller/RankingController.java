package com.ssafy.raid.ranking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.raid.ranking.dto.Ranking;
import com.ssafy.raid.ranking.service.RankingService;

@RestController
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@GetMapping("/ranking")
	public ResponseEntity<Iterable<Ranking>> getAllRanking(){
		return ResponseEntity.ok(rankingService.getAllRanking());
	}
	
	@PostMapping("/ranking")
	public ResponseEntity<Ranking> postRanking(@RequestBody Ranking ranking){
		return ResponseEntity.ok(rankingService.insertRanking(ranking));
	}
}
