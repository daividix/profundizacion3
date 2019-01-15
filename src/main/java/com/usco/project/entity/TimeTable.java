package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Tabla que almacenara los horarios de atencion de un sitio
@Entity
@Table(name="TimeTable")
public class TimeTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id del horario
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	//id del sitio
	@OneToOne
	private Site site;
	
	//dia de la semana en el que empieza a trabajar el sitio
	@Column(name="initial_day", nullable=false)
	private byte initialDay;
	
	//dia de la semana en el que terminan de trabajar el sitio
	@Column(name="final_day", nullable=false)
	private byte finalDay;
	
	//hora que empiezan a trabjar en el sitio
	@Column(name="open_hour", nullable=false)
	private byte openHour;
	
	//hora que terminan de trabajar
	@Column(name="closed_hour", nullable=false)
	private byte closedHour;
	
	public TimeTable() {
		
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

	public byte getInitialDay() {
		return initialDay;
	}

	public void setInitialDay(byte initialDay) {
		this.initialDay = initialDay;
	}

	public byte getFinalDay() {
		return finalDay;
	}

	public void setFinalDay(byte finalDay) {
		this.finalDay = finalDay;
	}

	public byte getOpenHour() {
		return openHour;
	}

	public void setOpenHour(byte openHour) {
		this.openHour = openHour;
	}

	public byte getClosedHour() {
		return closedHour;
	}

	public void setClosedHour(byte closedHour) {
		this.closedHour = closedHour;
	}
	
	
}
