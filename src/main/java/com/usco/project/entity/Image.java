package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Tabla que guarda la informacion de una imagen
@Entity
@Table(name="image")
public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id del imagen
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	@ManyToOne
	private Site site;
	
	//guarda la url donde se encuentra almacenada la imagen
	@Column(name="url", nullable=false)
	private String url;

	@Column
	private String name;


	public Image(Site site, String url, String name) {
		this.site = site;
		this.url = url;
		this.name = name;
	}

	
	public Image() {
		
	}

	//getters setters
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
