package com.usco.project.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Se crea una entidad la cual creara una tabla llamada Calificacion en la base de datos
//Esta tabla guardara todas las calificaciones que han hechos los usuarios a determinado sitio
@Entity
@Table(name="calification")
public class Calification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//comentario
	//Columna id que se autogenera 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true)
	private Long id;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Site site;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private User user;
	
	//Columna calificacion que guardara la calificacion hecha por er usuario
	@Column(name="calification_value", nullable=false, precision=3, scale=2)
	private BigDecimal calificationValue;

	@Column
	private Date date;
	

	public Calification(Site site, User user, BigDecimal calificationValue, Date date) {
		this.site = site;
		this.user = user;
		this.calificationValue = calificationValue;
		this.date = date;
	}
	
	

	
	public Calification(BigDecimal calificationValue, Date date, String userName) {
		this.calificationValue = calificationValue;
		this.date = date;
		
		User user = new User();
		user.setUsername(userName);
		
		this.user = user;
	}




	public Calification () {
		
	}


	public Long getId() {
		return id;
	}


	public Site getSite() {
		return site;
	}


	public User getUser() {
		return user;
	}


	public BigDecimal getCalificationValue() {
		return calificationValue;
	}


	public Date getDate() {
		return date;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setCalificationValue(BigDecimal calificationValue) {
		this.calificationValue = calificationValue;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
