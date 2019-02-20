package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.project.entity.Calification;
import com.usco.project.repository.CalificationRepository;

@Service("calification_service")
public class CalificationService {

	@Autowired
	private CalificationRepository calificationRepo;
	
	public void guardar(Calification calificacion) {
		
		calificationRepo.save(calificacion);
	}
	
	public List<Calification> listarPorSiteId(long id) {
		
		return calificationRepo.listarPorSiteId(id);
	}
}
