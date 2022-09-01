package com.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		System.out.println("Encoder is ready...............");
		return new BCryptPasswordEncoder();//spring bean Autowired(another way create singlton object)
	}

}
