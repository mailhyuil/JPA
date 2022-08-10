package com.sb.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.school.domain.Classes;
import com.sb.school.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
//  public void deleteByUsername(String username); // deleteById가 기본으로 정의되어 있음
    
	public User findOneByUsername(String username);
    
    public List<User> findByPassword(String password);
    
    public List<User> findByClassCode(Classes classCode);
    
    public User findOneByName(String name);
}
