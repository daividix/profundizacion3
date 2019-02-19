package com.usco.project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.usco.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@RestController
public class ActivationUserController {

    @Autowired
    @Qualifier("repositorio_usuario")
    private UserRepository userRepository;


    /* @GetMapping(value="/activation/user/{user_id}")
    public String activarUsuario(@PathVariable("user_id") Long user_id) {
        User user = userRepository.findById(user_id);
        if (user != null) {
            if (user.getState() == 1) {
                return "forward:/activation/false";
            }
            if (user.getState() == 2) {
                return "forward:/activation/user/{user_id}";
            }
            return "forward:/activation/false";
        }else{
            return "forward:/activation/false";
        }
    } */
    
}