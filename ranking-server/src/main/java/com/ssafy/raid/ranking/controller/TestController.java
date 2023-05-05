package com.ssafy.raid.ranking.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public ResponseEntity<?> whoami(HttpSession session){
		Enumeration<String> ss = session.getAttributeNames();
		while(ss.hasMoreElements()) {
			System.out.println(ss.nextElement());
		};
		System.out.println("end");
		return ResponseEntity.ok("you got a temp session");
		
	}

}
