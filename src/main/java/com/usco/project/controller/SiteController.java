package com.usco.project.controller;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.project.entity.Category;
import com.usco.project.entity.Service;
import com.usco.project.entity.Site;
import com.usco.project.message.request.SiteForm;
import com.usco.project.service.CategoryService;
import com.usco.project.service.ServiceService;
import com.usco.project.service.SiteService;

@RestController
@RequestMapping("/api/v1/sitio")
public class SiteController {

	@Autowired
	@Qualifier("site_service")
	private SiteService siteService;
	
	@Autowired
	@Qualifier("category_service")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("service_service")
	private ServiceService serviceService;
	
	@GetMapping("/verSitio/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Hashtable<Object,Object> verSitioPorId(@PathVariable("id") Long id){
		Hashtable<Object,Object> response = new Hashtable<Object,Object>();
		Site sitio = siteService.verSitioPorId(id);
		if(sitio != null) {
			response.put("isOk", true);
			response.put("sitio", sitio);
			response.put("message", "El sitio fue encontrado");
			return response;
		}else {
			response.put("isOk", false);
			response.put("message", "El no existe");
			return response;
		}
	}
	
	@GetMapping("/verSitios")
	public Hashtable<Object,Object> verSitios(){
		Hashtable<Object,Object> response = new Hashtable<Object,Object>();
		
		try {
			List<Site> sitios = siteService.verSitios();
			response.put("isOk", true);
			response.put("sitios", sitios);
			response.put("message", "Los sitios fueron encontrados");
			return response;
		}catch(Exception e) {
			response.put("isOk", false);
			response.put("message", e.toString());
			return response;
		}
	}
	
	@PostMapping("/agregarSitio")
	@PreAuthorize("hasRole('ADMIN')")
	public Hashtable<Object,Object> agregarSitio(@Valid @RequestBody SiteForm siteForm){
		Hashtable<Object,Object> response = new Hashtable<Object,Object>();
		Site newSitio = new Site(siteForm.getName(),siteForm.getAddress(), siteForm.getCity(),
				siteForm.getLatitude(), siteForm.getLongitude(), siteForm.getPhoneNumber(),
				siteForm.getEslogan(), siteForm.getInformation(), siteForm.getCalification(), siteForm.getClicks(), 1);
		
		List<Category> categorias =  categoryService.getCategories();
		List<Service> servicios = serviceService.getServices();
		
		Set<Long> strCategories = siteForm.getCategories();
		Set<Category> categories = new HashSet<>();
		Set<Long> strServices = siteForm.getServices();
		Set<Service> services = new HashSet<>();
		
		categorias.forEach(categoria -> {
			strCategories.forEach(idCategoria -> {
				if(idCategoria.equals(categoria.getId())) {
					categories.add(categoria);
				}
			});
		});
		
		servicios.forEach(servicio -> {
			strServices.forEach(idService -> {
				if(idService.equals(servicio.getId())) {
					services.add(servicio);
				}
			});
		});
		
		newSitio.setCategories(categories);
		newSitio.setServices(services);
		
		Boolean sitioFueCreado = siteService.crearSitio(newSitio);
		
		if(sitioFueCreado) {
			response.put("isOk", true);
			response.put("message", "El sitio fue creado satisfactoriamente");
			return response;
		}else {
			response.put("isOk", false);
			response.put("message", "No se pudo crear el sitio");
			return response;
		}
	}
}
