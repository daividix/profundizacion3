package com.usco.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.project.entity.Calification;
import com.usco.project.service.CalificationService;

@RestController
@RequestMapping("/api/v1/calificacion")
public class CalificacionApi {

	@Autowired
	private CalificationService calificationService;
	
	@PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(@RequestBody Calification calification) {
		
		ResponseEntity<?> response = null;
		
		try {
			
			calificationService.guardar(calification);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(value = "/listarPorSiteId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listarPorSiteId(@PathVariable("id") long id) {
		
		ResponseEntity<?> response = null;
		
		try {
			
			List<Calification> lstCalification = calificationService.listarPorSiteId(id);
			response = new ResponseEntity<>(lstCalification, HttpStatus.OK);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
