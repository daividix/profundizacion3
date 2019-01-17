package com.usco.project.repository;

import org.springframework.stereotype.Repository;

import com.usco.project.entity.Site;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("site_repository")
public interface SiteRepository extends JpaRepository<Site, Long>{

	public abstract Site findById(Long id);
}
