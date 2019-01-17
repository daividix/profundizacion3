package com.usco.project.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.User;

@Repository("repositorio_usuario")
public interface UserRepository extends JpaRepository<User, Serializable>{

	public abstract User findById(Long id);
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public abstract User getInfoUser(String username);
}
