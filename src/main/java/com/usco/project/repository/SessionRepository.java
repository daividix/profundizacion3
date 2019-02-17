package com.usco.project.repository;

import java.util.List;

import com.usco.project.entity.Session;
import com.usco.project.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("session_repository")
public interface SessionRepository extends JpaRepository<Session, Long>{

    public abstract List<Session> findByUser(User user);

    @Query("SELECT s FROM Session s WHERE s.date BETWEEN ?1 AND ?2")
    public abstract List<Session> findByDate(String date1, String date2);
}