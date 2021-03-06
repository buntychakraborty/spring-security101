package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAuthProvider authenticationProvider;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
//		detailsManager.createUser(User.withUsername("Bunty").password(bCryptPasswordEncoder.encode("12345")).authorities("read").build());
//		auth.userDetailsService(detailsManager).passwordEncoder(bCryptPasswordEncoder);
//
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
//		http.formLogin();
		http.authorizeRequests().antMatchers("/hello").authenticated();
		http.addFilterBefore(new MyCustomFilter(), BasicAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder gBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
