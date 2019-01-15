package com.usco.project.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.project.entity.User;

@Repository("repositorio_usuario")
public interface UserRepository extends JpaRepository<User, Serializable>{

	public abstract User findById(long id);
	
	public abstract List<User> findByUsername(String Username);
}
