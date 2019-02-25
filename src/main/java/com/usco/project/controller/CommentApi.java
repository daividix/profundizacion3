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

import com.usco.project.entity.Comment;
import com.usco.project.service.CommentService;
import com.usco.project.message.response.Response;

@RestController
@RequestMapping("/api/v1/comentario")
public class CommentApi {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response guardar(@RequestBody Comment comment) {
		
		Response response = new Response();
		
		try {
			commentService.guardar(comment);
			response.setIsOk(true);
			response.setMessage("Comentario guardado correctamente");
			//response = new ResponseEntity<>(HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setIsOk(false);
			response.setMessage("Error al guardar comentario");
			//response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
		
	
	@GetMapping(value = "listarPorSiteId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listarPorSiteId(@PathVariable("id") long id) {
		
		Response response = new Response();
		
		try {
			
			List<Comment> lstComment = commentService.listarPorSiteId(id);
			response.setIsOk(true);
			response.setResults(lstComment);
			response.setMessage("Los comentaros fueron listados por id correctamente");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setIsOk(false);
			response.setMessage("Error al listar los comentarios");
			
		}
		
		return response;
	}

}
