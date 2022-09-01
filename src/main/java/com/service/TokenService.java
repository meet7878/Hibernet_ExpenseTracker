package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.UserBean;
import com.repository.UserRepository;

@Service
public class TokenService {

	@Autowired
	UserRepository userRepo;

	public String generateToken(int size) {// 3
		String allWords = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		String token = "";
		UserBean dbUser = null;
		do {
			token = "";
			for (int i = 1; i <= size; i++) {
				int index = (int) (allWords.length() * Math.random());
				token = token + allWords.charAt(index);
			}
			 dbUser = userRepo.findByAuthToken(token);
		} while (dbUser != null);
		return token;
	}
	
}
