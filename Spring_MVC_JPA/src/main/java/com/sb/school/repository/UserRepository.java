package com.sb.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.school.domain.User;


public interface UserRepository extends JpaRepository<User, String>{
    
    public User findOneByUsername(String username);
//    public void deleteByUsername(String username); // deleteById가 기본으로 정의되어 있음
    
    public String findClassByUsername(String username);
    public List<User> findListByClassCode(String class_code);
}
