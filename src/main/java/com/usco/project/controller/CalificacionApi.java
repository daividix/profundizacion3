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
import com.usco.project.message.response.Response;
import com.usco.project.service.CalificationService;

@RestController
@RequestMapping("/api/v1/calificacion")
public class CalificacionApi {

	@Autowired
	private CalificationService calificationService;
	
	@PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response guardar(@RequestBody Calification calification) {
		
		Response response = new Response();
		
		try {
			
			calificationService.guardar(calification);
			response.setIsOk(true);
			response.setMessage("Calificacion guardada correctamente");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response.setIsOk(false);
			response.setMessage("Error al guardar la calificacion");
			
		}
		
		return response;
	}
	
	@GetMapping(value = "/listarPorSiteId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listarPorSiteId(@PathVariable("id") long id) {
		
		Response response = new Response();
		
		try {
			
			List<Calification> lstCalification = calificationService.listarPorSiteId(id);
			response.setIsOk(true);
			response.setResults(lstCalification);
			response.setMessage("Las calificaciones fueron listadas por id correctamente");
			//response = new ResponseEntity<>(lstCalification, HttpStatus.OK);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response.setIsOk(false);
			response.setMessage("Error al listar las califaciones");
			//response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
