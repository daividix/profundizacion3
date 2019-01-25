package com.usco.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Search_History")
public class SearchHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="content", length= 100)
	private String content;
	
	@Column(name="date")
	private Date date;

	@ManyToOne
	private City city;

	@ManyToOne
	private User user;

	public SearchHistory(String content, Date date, City city, User user) {
		this.content = content;
		this.date = date;
		this.city = city;
		this.user = user;
	}
	
	public SearchHistory() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
