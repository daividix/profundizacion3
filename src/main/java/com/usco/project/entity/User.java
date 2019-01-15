package com.usco.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Tabla que guardara la informacion de los usuarios
@Entity
@Table(name="Users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id del usuario, autogenerado
	@Id
	@GeneratedValue
	@Column(name="id", unique=true)
	private long id;
	
	//nombre de usuario, no se puede repetir
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	//contraseña del usuario para ingresar
	@Column(name="password", nullable=false)
	private String password;
	
	//correo del usuario
	@Column(name="state", nullable=false)
	private String state;
	
	@OneToOne
	private Person person;
	
	public User(long id, String username, String password, String state, Person person) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.state = state;
		this.person = person;
	}

	public User() {
		
	}

	//Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
