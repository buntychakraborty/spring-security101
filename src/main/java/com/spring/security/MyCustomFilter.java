package com.spring.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(
				"Write the logic that you want to run before moving to next component in the spring secuirty life cycle");
		chain.doFilter(request, response);
		System.out.println(
				"Write the logic that you want to run once everything is go and you are on the way to get response.");

	}

}
