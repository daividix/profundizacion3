package com.usco.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.project.entity.User;
import com.usco.project.repository.UserRepository;

@Service("servicio_user")
public class UserServices {

	@Autowired
	@Qualifier("repositorio_usuario")
	private UserRepository userRepository;
	
	public User getUserInformation(String username) {
		return userRepository.getInfoUser(username);
	}
}
