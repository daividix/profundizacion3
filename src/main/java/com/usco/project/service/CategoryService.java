package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.project.entity.Category;
import com.usco.project.repository.CategoryRepository;

@Service("category_service")
public class CategoryService {

	@Autowired
	@Qualifier("category_repository")
	private CategoryRepository categoryRepository;
	
	public List<Category> verCategorias(){
		
		return categoryRepository.findAll();
	}
}
