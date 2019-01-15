package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Esta tabla guardara todos los comentarios que haya hecho un usuario a un sitio
@Entity
@Table(name="Comment")
public class Comment implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Autogenerado, guarda el id del comentario 
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Site site;
	
	//Columna donde se almacena el contenido del comentario
	@Column(name="content", nullable=false)
	private String content;
	
	//Columna que almacena el numero de reportes que tiene un comentario
	@Column(name="reports")
	private int reports;
	
	//Almacena el numero de likes que tiene el comentario
	@Column(name="likes")
	private int likes;
	
	//Almacena el numero de dislikes de un comentario
	@Column(name="dislikes")
	private int dislikes;
	
	public Comment() {
		
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

	public int getReports() {
		return reports;
	}

	public void setReports(int reports) {
		this.reports = reports;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	
	
}
