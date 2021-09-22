package com.spring.security;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void testEncoders() {
		//BCryptPasswordEncoder
		System.out.println(new BCryptPasswordEncoder().encode("Bunty"));
		//Pbkdf2PasswordEncoder
		System.out.println(new Pbkdf2PasswordEncoder().encode("jafsj"));
		//SCryptPasswordEncoder
		System.out.println(new SCryptPasswordEncoder().encode("jafsj"));
		
		//DelegatingPasswordEncoder
		Map<String, PasswordEncoder> passMap=new HashMap<String, PasswordEncoder>();
		passMap.put("bcrypyt", new BCryptPasswordEncoder());
		passMap.put("scrypyt", new SCryptPasswordEncoder());
		System.out.println(new DelegatingPasswordEncoder("bcrypyt",passMap).encode("bunty"));
	}

}
