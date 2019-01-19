package com.usco.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.Category;

@Repository("category_repository")
public interface CategoryRepository extends JpaRepository<Category, Long>{

    public abstract Category findById(Long id);

}
