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
	
	public List<com.usco.project.entity.Service> getServices(){
		return serviceRepository.findAll();
	}

	public com.usco.project.entity.Service getById(Long id){
		com.usco.project.entity.Service service = serviceRepository.findById(id);
		return service;
	}

	public com.usco.project.entity.Service addService(com.usco.project.entity.Service service) {
		com.usco.project.entity.Service newService = serviceRepository.save(service);
		return newService;
	}

	public Boolean deleteService (Long id) {
		try {
			com.usco.project.entity.Service service = serviceRepository.findById(id);
			serviceRepository.delete(service);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
