package com.usco.project.message.request;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class SiteForm {

	@NotBlank
	@Size(min=3, max=50)
	private String name;
	
	@NotBlank
	@Size(min=3, max=60)
	private String address;
	
	@NotBlank
	@Size(min=3, max=20)
	private String city;
	
	@NotBlank
	@Size(min=3, max=20)
	private String latitude;
	
	@NotBlank
	@Size(min=3, max=20)
	private String longitude;
	
	@NotBlank
	@Size(min=3, max=20)
	private String phoneNumber;
	
	@NotBlank
	@Size(min=3, max=20)
	private String eslogan;

	@NotBlank
	@Size(min=3, max=1000)
	private String information;
	
	@Min(value = 0)
	@Max(value = 5)
	private float calification;
		
	private long clicks;
		
	private Set<Long> services;

	private Set<Long> categories;
	
	
	//Getters setters
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

	public Set<Long> getServices() {
		return services;
	}

	public void setServices(Set<Long> services) {
		this.services = services;
	}

	public Set<Long> getCategories() {
		return categories;
	}

	public void setCategories(Set<Long> categories) {
		this.categories = categories;
	}
		
		
}
