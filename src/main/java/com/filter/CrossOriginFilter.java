	package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class CrossOriginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest reqx, ServletResponse respx, FilterChain chain)
			throws IOException, ServletException {
	
		System.out.println("crossOrigin Filter.........");
		HttpServletRequest request = (HttpServletRequest) reqx;
		HttpServletResponse response = (HttpServletResponse) respx;
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE,PUT,OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me,authToken");

		System.out.println("token of CrossFilter	 => " + request.getHeader("authToken"));
		chain.doFilter(reqx, respx);
		
		
	}

}
