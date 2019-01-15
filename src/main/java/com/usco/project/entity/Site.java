package com.usco.project.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Tabla que guardara todos los sitios
@Entity
@Table(name="sites")
public class Site implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Id del sitio, Autogenerado
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	//nombre del sitio
	@Column(name="name", nullable=false)
	private String name;
	
	//Direccion del sitio
	@Column(name="address", nullable=false)
	private String address;
	
	//Ciudad donde se encuentra el sitio
	@Column(name="city")
	private String city;
	
	//Latitud y longitud para encontrar el sitio el google maps
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	//Numero de telefono del Sitio
	@Column(name="phoneNumber", nullable=false)
	private String phoneNumber;
	
	//Eslogan
	@Column(name="eslogan")
	private String eslogan;
	
	
	//informacion extra del sitio
	@Column(name="information",length=1000)
	private String information;
	
	
	//Calificacion del sitio
	@Column(name="calification")
	private float calification;
	
	@Column(name="clicks")
	private long clicks;
	
	@ManyToMany(targetEntity=Service.class)
	private Set services;
	
	@ManyToMany(targetEntity=Category.class)
	private Set categories;
	
	public Site(long id, String name, String address, String city, String latitude, String longitude,
			String phoneNumber, String eslogan, String information, float calification, long clicks) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
		this.eslogan = eslogan;
		this.information = information;
		this.calification = calification;
		this.clicks = clicks;
	}

	public Site() {
		
	}

	//Getters y Setters
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEslogan() {
		return eslogan;
	}

	public void setEslogan(String eslogan) {
		this.eslogan = eslogan;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}


	public float getCalification() {
		return calification;
	}

	public void setCalification(float calification) {
		this.calification = calification;
	}

	public long getClicks() {
		return clicks;
	}

	public void setClicks(long clicks) {
		this.clicks = clicks;
	}
	
	
}
