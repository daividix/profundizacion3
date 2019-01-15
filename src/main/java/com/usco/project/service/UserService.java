package com.usco.project.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.usco.project.entity.User;

import com.usco.project.repository.UserRepository;

@Service("servicio_user")
public class UserService {

	@Autowired
	@Qualifier("repositorio_usuario")
	private UserRepository userRepository;
	
	
	private static final Log logger = LogFactory.getLog(UserService.class);
	
	public boolean crearUsuario(User user) {
		logger.info("Creando Sitio");
		try {
			userRepository.save(user);
			return true;
		}catch(Exception e){
			logger.error("Error al crear usuario");
			return false;
		}
	}
	
	public List<User> verUsuarioPorUsername(String username) {	
		return userRepository.findByUsername(username);
	}
	
	public List<User> obtener(){
		return userRepository.findAll();
	}
}
