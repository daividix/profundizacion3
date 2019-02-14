package com.usco.project.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.usco.project.entity.Site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository("site_repository")
public interface SiteRepository extends JpaRepository<Site, Long>{

	public abstract Site findById(Long id);

	@Query("SELECT s from Site s WHERE LOWER(s.name) LIKE ?1")
	public abstract List<Site> getLikeName(String name);
}
