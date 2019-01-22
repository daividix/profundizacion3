package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Tabla que guarda los sitios pendientes por visitar de los usuarios 
@Entity
@Table(name="PendingSite")
public class PendingSite implements Serializable{

	private static final long serialVersionUID = 1L;

	// id del sitio pendiente, autogenerado
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	@ManyToOne
	private Site site;
	
	@ManyToOne
	private User user;
	
	public PendingSite() {
		
	}

	//Getters Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
