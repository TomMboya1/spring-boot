package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
	@GetMapping(value = "/good-morning")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Good morning!");
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return ResponseEntity.ok("Good Afternoon!");
	}
	@GetMapping("/info")
	public ResponseEntity<String> getInfo() {
		return ResponseEntity.ok("Information Endpoint");
	}

	@GetMapping("/random")
	public ResponseEntity<String> getRandom() {
		boolean isRandom = new Random().nextBoolean();
		if (isRandom) {
			return ResponseEntity.ok("200 OK");
		} else {
			return ResponseEntity.badRequest().body("400 Bad Request");
		}
	}
}
