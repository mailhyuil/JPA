package com.sb.school.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sb.school.domain.User;

@Repository
public class UserRepository {
	
    @PersistenceContext
    EntityManager em;
    
    public int save(User user) {
    	em.persist(user);
    	return 0;
    }
    
    public User findById(String username) {
    	return em.find(User.class, username);
    }
}
