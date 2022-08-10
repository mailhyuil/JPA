package com.sb.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;

public interface UserService {
	
    public String join(User user) throws Exception;
	
	public List<User> getList();
	
	public int deleteUser(String username);
}
