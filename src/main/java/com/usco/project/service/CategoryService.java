package com.usco.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.project.entity.Category;
import com.usco.project.message.request.CategoryForm;
import com.usco.project.repository.CategoryRepository;

@Service("category_service")
public class CategoryService {

	@Autowired
	@Qualifier("category_repository")
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories(){
		
		return categoryRepository.findAll();
	}

	public Category getById(Long id){
		return categoryRepository.findById(id);
	}

	public Category addCategory(Category category){
		Category newCategory = categoryRepository.save(category);
		return newCategory;
	}

	public Boolean deleteCategory(Long id) {	
		try {
			Category category = categoryRepository.findById(id);
			categoryRepository.delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Category updateCategory(Long id, CategoryForm newCategory) {
		Category category = categoryRepository.findById(id);
		if (newCategory.getName() != null) {
			category.setName(newCategory.getName());
		}
		if (newCategory.getInfo() != null) {
			category.setInfo(newCategory.getInfo());
		}
		if (newCategory.getIcon() != null) {
			category.setIcon(newCategory.getIcon());
		}
		if (newCategory.getState() != null) {
			category.setState(newCategory.getState());
		}	
		categoryRepository.save(category);
		return category;
	}

}
