package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.project.repository.ServiceRepository;

@Service("service_service")
public class ServiceService {

	@Autowired
	@Qualifier("service_repository")
	private ServiceRepository serviceRepository;
	
	public List<com.usco.project.entity.Service> verServicios(){
		return serviceRepository.findAll();
	}
}
