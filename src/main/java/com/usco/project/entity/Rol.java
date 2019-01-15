package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rol")
public class Rol implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="info", length=300, nullable=false)
	private String info;
	
	
	public Rol(long id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
	}

	public Rol () {
		
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

	public String getInfor() {
		return info;
	}

	public void setInfor(String info) {
		this.info = info;
	}
	
	
	
}
