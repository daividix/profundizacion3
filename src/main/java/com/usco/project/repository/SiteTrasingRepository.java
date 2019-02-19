package com.usco.project.repository;

import com.usco.project.entity.SiteTrasing;
import com.usco.project.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("site_trasing_repository")
public interface SiteTrasingRepository extends JpaRepository<SiteTrasing, Long>{

    public abstract SiteTrasing findBySiteId(Long siteId);

    public abstract SiteTrasing findByUser(User user);
}