package com.usco.project.controller;

import java.util.List;

import javax.validation.Valid;

import com.usco.project.entity.Category;
import com.usco.project.message.request.CategoryForm;
import com.usco.project.message.response.Response;
import com.usco.project.service.CategoryService;

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
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    @Qualifier("category_service")
    CategoryService categoryService;

    @GetMapping("/verCategorias")
    @PreAuthorize("hasRole('ADMIN')")
    public Response verCategorias () {
        try {
            
            List<Category> categories = categoryService.getCategories();
            Response response = new Response(true, "Las categorias fueron encontradas");
            response.setResults(categories);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error");
            response.setError(e.toString());
            return response;
        }
    }

    @GetMapping("/verCategoria/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response verCategoria (@PathVariable("id") Long id) {
        try {
            Category category = categoryService.getById(id);
            Response response = new Response(true, "Categoria encontrada");
            response.setResult(category);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error");
            response.setError(e.toString());
            return response;
        }
    }

    @PostMapping("/agregarCategoria")
    @PreAuthorize("hasRole('ADMIN')")
    public Response agregarCategoria (@Valid @RequestBody CategoryForm form) {
        Category category = new Category(form.getName(), form.getInfo(), 
            form.getIcon(), form.getState());
        try {
            Category newCategory = categoryService.addCategory(category);
            Response response = new Response(true, "Categoria agregada");
            response.setResult(newCategory);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al agregar la categoria");
            response.setError(e.toString());
            return response;
        }
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response eliminarCategoria (@PathVariable("id") Long id) {
        try {
            categoryService.deleteCategory(id);
            Response response = new Response(true, "Categoria eliminada");
            return response;     
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al eliminar la categoria");
            response.setError(e.toString());
            return response;
        }    
    }

    @PutMapping("/actualizarCategoria/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response actualizarCategoria (@PathVariable("id") Long id, @RequestBody CategoryForm form) {
        try {
            Category updatedCategory = categoryService.updateCategory(id, form);
            Response response = new Response(true, "La categoria se actualizo correctamente");
            response.setResult(updatedCategory);
            return response;
        } catch (Exception e) {
            Response response = new Response(false, "Hubo un error al actualizar la categoria");
            response.setError(e.toString());
            return response;
        }
    }
}