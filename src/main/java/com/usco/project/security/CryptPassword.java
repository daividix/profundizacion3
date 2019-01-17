package com.usco.project.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptPassword {
	
	public CryptPassword() {
		
	}
	
	public String generate(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}

	public boolean compare(String password, String crypPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, crypPassword);
	}
}
