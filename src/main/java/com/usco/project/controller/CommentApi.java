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

@RestController
@RequestMapping("/api/v1/comentario")
public class CommentApi {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(@RequestBody Comment comment) {
		
		ResponseEntity<?> response = null;
		
		try {
			
			commentService.guardar(comment);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(value = "listarPorSiteId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listarPorSiteId(@PathVariable("id") long id) {
		
		ResponseEntity<?> response = null;
		
		try {
			
			List<Comment> lstComment = commentService.listarPorSiteId(id);
			response = new ResponseEntity<>(lstComment, HttpStatus.OK);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

}
