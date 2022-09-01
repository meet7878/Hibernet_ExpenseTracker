	package com.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthTokenFilter implements Filter {
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		HttpServletRequest req = ((HttpServletRequest)(request));
		
		String  url = req.getRequestURL().toString();
		System.out.println("incoming url ---> " + url);
		
		if(url.contains("/public/")  || req.getMethod().toLowerCase().equals("options")) {
			chain.doFilter(request, response);
			
		}else {
			
			/*
			 * Enumeration<String> allHeaders = req.getHeaderNames(); while
			 * (allHeaders.hasMoreElements()) {
			 * System.out.println(allHeaders.nextElement());
			 * //System.out.println(hName+" => "+request.getHeader(hName)); }
			 * System.out.println("***************");
			 */
			
			String authToken =  req.getHeader("authToken");
			System.out.println("authtokenFilter => " +authToken);
			
			if(authToken == null || authToken.trim().length() != 16) {
				System.out.println("token verification failed.................");
				HttpServletResponse resp = ((HttpServletResponse) response);
				resp.setContentType("appliction/json");
				resp.setStatus(401);
				resp.getWriter().write("{'msg' : 'please login before access services '}");
			}else {
				System.out.println("user verifyed.......");
				chain.doFilter(request, response);
			}
			
			
		}
		
		
		
	}

}
