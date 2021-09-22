package com.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Rockkss";
	}

	@GetMapping("/bye")
	public String bye() {
		return "Get Lost";
	}
}
