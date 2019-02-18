package com.usco.project.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.project.entity.Category;
import com.usco.project.entity.Service;
import com.usco.project.entity.Site;
import com.usco.project.entity.SiteTrasing;
import com.usco.project.entity.User;
import com.usco.project.message.request.SiteForm;
import com.usco.project.message.response.Response;
import com.usco.project.repository.SiteRepository;
import com.usco.project.service.CategoryService;
import com.usco.project.service.ServiceService;
import com.usco.project.service.SiteService;
import com.usco.project.service.SiteTrasingService;
import com.usco.project.service.UserServices;

@RestController
@RequestMapping("/api/v1/sitio")
public class SiteController {

	@Autowired
	@Qualifier("site_service")
	private SiteService siteService;

	@Autowired
	@Qualifier("site_repository")
	private SiteRepository siteRepository;

	@Autowired
	@Qualifier("servicio_user")
	private UserServices userService;
	
	@Autowired
	@Qualifier("category_service")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("service_service")
	private ServiceService serviceService;

	@Autowired
	@Qualifier("site_trasing_service")
	private SiteTrasingService siteTrasingService;
	
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
	public Hashtable<Object,Object> agregarSitio(@Valid @RequestBody SiteForm siteForm, Principal principal, HttpServletRequest req){
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
		
		Site sitioCreado = siteRepository.save(newSitio);
		
		if(sitioCreado != null) {
			User userLoggued = userService.getUserInformation(principal.getName().toString());
			SiteTrasing siteTrasing = new SiteTrasing(newSitio.getId(), userLoggued, "CREATE", new Date(), req.getRemoteAddr());
			Boolean siteTrasingIsCreated = siteTrasingService.addSiteTrasing(siteTrasing);
			if (siteTrasingIsCreated) {
				response.put("isOk", true);
				response.put("message", "El sitio fue creado satisfactoriamente");
			} else {
				siteService.delete(sitioCreado);
				response.put("isOk", false);
				response.put("message", "No se pudo hacer seguimiento a la tabla sitios");
			}
			
			return response;
		}else {
			response.put("isOk", false);
			response.put("message", "No se pudo crear el sitio");
			return response;
		}
	}

	@GetMapping(value="/buscarPorNombre/{name}")
	public Response postMethodName(@PathVariable("name") String name) {
		if (name != null) {
			List<Site> sites = siteService.getUserLikeName(name);
			Response response = new Response(true, "Sitios encontrados");
			response.setResults(sites);
			return response;
		}else{
			Response response = new Response(false, "No escribio un nombre");
			return response;
		}
	}
	
	
	@DeleteMapping("/eliminarSitio/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Response eliminarSitio(@PathVariable("id") Long id, Principal principal, HttpServletRequest req) {
		User userLoggued = userService.getUserInformation(principal.getName().toString());
		try {
            Site sitio = siteService.verSitioPorId(id);
			siteService.delete(sitio);
			SiteTrasing siteTrasing = new SiteTrasing(sitio.getId(), userLoggued, "DELETE", new Date(), req.getRemoteAddr());
			siteTrasingService.addSiteTrasing(siteTrasing);

            Response response = new Response();        
            response.setIsOk(true);
			response.setMessage("El Sitio se ha eliminado correctamente");  
			return response;          
            
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al eliminar el Sitio");
			response.setError(e.toString());
			return response;
        }
		
	}
	
	@PutMapping("/actualizarSitio/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Response actualizarSitio(@RequestBody SiteForm sitio ,@PathVariable Long id,SiteForm siteForm,
	Principal principal, HttpServletRequest req) {
		User userLoggued = userService.getUserInformation(principal.getName().toString());
		try{
		Site site = siteService.verSitioPorId(id);
		site.setName(sitio.getName());
		site.setAddress(sitio.getAddress());
		site.setCity(sitio.getCity());
		site.setLatitude(sitio.getLatitude());
		site.setLongitude(sitio.getLongitude());
		site.setPhoneNumber(sitio.getPhoneNumber());
		site.setEslogan(sitio.getEslogan());
		site.setInformation(sitio.getInformation());
		site.setCalification(sitio.getCalification());
		
		
		siteService.crearSitio(site);
		SiteTrasing siteTrasing = new SiteTrasing(site.getId(), userLoggued, "UPDATE", new Date(), req.getRemoteAddr());
			siteTrasingService.addSiteTrasing(siteTrasing);
		Response response = new Response(true, "Se ha actualizado correctamente el Sitio");
		response.setIsOk(true);
		response.setMessage("El Sitio se ha actualizado correctamente");  
        response.setResult(site);
        return response;
		}catch(Exception e){
			 Response response = new Response(false, "Hubo un error al actualizar el Sitio");
	         response.setError(e.toString());
	         return response;
			
		}
		
		
	}
	
	@GetMapping(value="/SitiosPolulares")
	public Response populares() {
			try {
				List<Site> sites = siteService.getUserLikeCalification();
				Response response = new Response(true, "Sitios encontrados");
				response.setResults(sites);
				return response;
			}catch(Exception e){
				Response response = new Response(false, "Sitios no encontrados");
				response.setError(e.toString());
				return response;
			}
		
	}
	
	
	
	
	
	
}
