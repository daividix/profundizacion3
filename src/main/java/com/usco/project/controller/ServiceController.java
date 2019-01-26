package com.usco.project.controller;

import java.util.List;

import com.usco.project.entity.Service;
import com.usco.project.message.response.Response;
import com.usco.project.service.ServiceService;

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

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    @Autowired
    @Qualifier("service_service")
    ServiceService serviceService;

    @GetMapping("/verServicios")
    @PreAuthorize("hasRole('ADMIN')")
    public Response verServicios() {
        try {
            List<Service> services = serviceService.getServices();
            Response response = new Response(true, "Servicios encontrados");
            response.setResults(services);
            return response;
        } catch (Exception e) {
            Response response = new Response(false,"Hubo un error al buscar los sitios");
            response.setError(e.toString());
            return response;
        }
        
    }

    @GetMapping("/verServicio/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response verServicio(@PathVariable("id") Long id) {
        try {
            Service servicio = serviceService.getById(id);
            Response response = new Response();
            response.setIsOk(true);
            response.setMessage("El servicio fue encontrado");
            response.setResult(servicio);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un problema al buscar el servicio");
            response.setError(e.toString());
            return response;
        }
    }

    @PostMapping("/agregarServicio")
    @PreAuthorize("hasRole('ADMIN')")
    public Response agregarServicio(@RequestBody Service formService) {
        try {
            Service newServicio = serviceService.addService(formService);
            Response response = new Response(true, "El servicio se ha agregado correctamente");
            response.setResult(newServicio);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Ocurrio un error");
            response.setError(e.toString());
            return response;
        }
    }

    @DeleteMapping("/eliminarServicio/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response eliminarServicio(@PathVariable("id") Long id){
        try {
            Boolean servicioIsDeleted = serviceService.deleteService(id);
            Response response = new Response();
            if (servicioIsDeleted) {
                response.setIsOk(true);
                response.setMessage("El servicio se ha eliminado correctamente");
                return response;
            }else{
                response.setIsOk(false);
                response.setMessage("El servicio no se ha podido eliminar, no se puede eliminar un servicio que un sitio este usando");
                return response;
            }
            
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al eliminar el servicio");
            response.setError(e.toString());
            return response;
        }
    }

    @PutMapping("/actualizarServicio/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response actualizarServicio(@PathVariable("id") Long id, @RequestBody Service serviceForm) {
        try {
            Service updatedServicio = serviceService.updateService(id, serviceForm);
            Response response = new Response(true, "Se ha actualizado correctamente el servicio");
            response.setResult(updatedServicio);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al acualizar el servicio");
            response.setError(e.toString());
            return response;
        }
    }
}