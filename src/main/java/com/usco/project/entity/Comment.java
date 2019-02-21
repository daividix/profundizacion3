package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Esta tabla guardara todos los comentarios que haya hecho un usuario a un sitio
@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Autogenerado, guarda el id del comentario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;

	// Columna donde se almacena el contenido del comentario
	@Column(name = "content", nullable = false)
	private String content;

	// Columna que almacena el numero de reportes que tiene un comentario
	@Column(name = "reports")
	private int reports;

	// Almacena el numero de likes que tiene el comentario
	@Column(name = "likes")
	private int likes;

	// Almacena el numero de dislikes de un comentario
	@Column(name = "dislikes")
	private int dislikes;

	public Comment() {

	}
	
	

	public Comment(String content, int likes, int dislikes, String userName) {
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
		
		User user = new User();
		user.setUsername(userName);
		
		this.user = user;
	}



	public void setReports(int reports) {
		this.reports = reports;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReports() {
		return reports;
	}

	public void setReports(Integer reports) {
		this.reports = reports;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

}
