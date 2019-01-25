package com.usco.project.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@GeneratedValue
	@Column(name="id", unique=true)
	private Long id;
	
	@ManyToOne
	private Site site;
	
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

	
	public Calification () {
		
	}
	
	
	//Metodos Getters y Setters para cada atributo
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


	public BigDecimal getCalification() {
		return calificationValue;
	}

	public void setCalification(BigDecimal calificationValue) {
		this.calificationValue = calificationValue;
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
