package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.project.entity.Comment;
import com.usco.project.repository.CommentRepository;

@Service("comment_service")
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	public void guardar(Comment comment) {
		
		commentRepo.save(comment);
	}
	
	public List<Comment> listarPorSiteId(long id) {
		
		return commentRepo.listarPorSiteId(id);
	}
}
