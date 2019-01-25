package com.usco.project.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Long id;
	
	@ManyToOne
	private Site site;
	
	@ManyToOne
	private User user;

	@Column
	private Date date;

	@Column
	private String comment;

	@Column
	private int state;
	
	public PendingSite() {
		
	}


	public PendingSite(Site site, User user, Date date, String comment, int state) {
		this.site = site;
		this.user = user;
		this.date = date;
		this.comment = comment;
		this.state = state;
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
	

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
