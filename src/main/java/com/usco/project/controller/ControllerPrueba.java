package com.usco.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPrueba {

    @GetMapping
    public String prueba () {
        return "Hello world!!";
    }
}