package com.usco.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.Service;

@Repository("service_repository")
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
