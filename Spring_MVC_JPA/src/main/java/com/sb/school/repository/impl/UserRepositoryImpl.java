package com.sb.school.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
    @PersistenceContext
    EntityManager em;
    
    public void save(User user) {
    	em.persist(user);
    }

    public List<User> findAll() {
    	List<User> resultList = em.createQuery("select u from User as u", User.class).getResultList();
    	return resultList;
    }

	@Override
	public int delete(String username) {
		User user = em.find(User.class, username);
		em.remove(user);
		return 0;
	}
}
