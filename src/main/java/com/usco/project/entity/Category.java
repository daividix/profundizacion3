package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Esta tabla guardara todas las categorias que hay para cada sitio
@Entity
@Table(name="Category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Almacena el id de la categoria, este campo sera autogenerado
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	//Columna donde se almacenara el nombre de la categoria
	@Column(name="name", unique=true)
	private String name;
	
	//Se almacena la informacion de la categoria
	@Column(name="info", length=300)
	private String info;
	
	
	//Se almacena la url de la imagen del icono de la categoria
	@Column(name="icon")
	private String icon;
	
	@Column(name="state")
	private String state;
	

	public Category(String name, String info, String icon, String state) {
		this.name = name;
		this.info = info;
		this.icon = icon;
		this.state = state;
	}


	public Category () {
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
