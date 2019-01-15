package com.usco.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.project.entity.User;
import com.usco.project.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	@Qualifier("servicio_user")
	private UserService service;
	
	@PostMapping("/user")
	public boolean agregarUsuario(@RequestBody User user) {
		if(service.verUsuarioPorUsername(user.getUsername()).size() >= 1) {
			return false;
		}else {
			return service.crearUsuario(user);
		}
	}
	@GetMapping("/user")
	public List<User> verTodo(){
		return service.obtener();
	}
}
