package com.usco.project.service;

import java.util.List;

import com.usco.project.entity.Session;
import com.usco.project.entity.User;
import com.usco.project.repository.SessionRepository;
import com.usco.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("session_service")
public class SessionService {

    @Autowired
    @Qualifier("session_repository")
    private SessionRepository sessionRepository;

    @Autowired
    @Qualifier("repositorio_usuario")
    private UserRepository userRepository;

    public Boolean addSession(Session session) {
        Session newSession = sessionRepository.save(session);
        if (newSession != null) {
            return true;
        }
        return false;
    }

    public List<Session> getByUser(Long id) {
        User user = userRepository.findById(id);
        List<Session> sessions = sessionRepository.findByUser(user);

        return sessions;
    }
}