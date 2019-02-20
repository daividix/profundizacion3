package com.usco.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.Comment;

@Repository("comment_repository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
	@Query("select new  com.usco.project.entity.Comment(c.content, c.likes, c.dislikes, c.user.username) "
			+ "from Comment c where c.site.id = ?1")
	List<Comment> listarPorSiteId(long id);
}
