package com.usco.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.Calification;

@Repository("calification_repository")
public interface CalificationRepository extends JpaRepository<Calification, Integer> {

	@Query("select new com.usco.project.entity.Calification(c.calificationValue, c.date, c.user.username) "
			+ "from Calification c where c.site.id = ?1")
	List<Calification> listarPorSiteId(long id);
}
