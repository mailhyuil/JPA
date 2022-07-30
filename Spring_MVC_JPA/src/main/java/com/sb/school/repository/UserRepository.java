package com.sb.school.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sb.school.domain.User;

public interface UserRepository {
    public void save(User user);
    public List<User> findAll();
    public int delete(String username);
}
