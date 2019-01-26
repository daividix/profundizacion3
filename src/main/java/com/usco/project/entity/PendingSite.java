package com.usco.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Site site;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private User user;

	@Column(nullable=false)
	private Date date;

	@Column(nullable=true)
	private String comment;

	@Column(nullable=false)
	private Integer state;
	
	public PendingSite() {
		
	}


	public PendingSite(Site site, User user, Date date, String comment, Integer state) {
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

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
