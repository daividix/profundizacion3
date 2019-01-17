package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.project.entity.Site;
import com.usco.project.repository.SiteRepository;

@Service("site_service")
public class SiteService {

	@Autowired
	@Qualifier("site_repository")
	private SiteRepository siteRepository;
	
	public Site verSitioPorId(Long id) {
		return siteRepository.findById(id);
	}
	
	public List<Site> verSitios(){
		return siteRepository.findAll();
	}
	
	public Boolean crearSitio(Site sitio) {
		try {
			siteRepository.save(sitio);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
