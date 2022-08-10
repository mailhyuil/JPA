package com.sb.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;
import com.sb.school.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
    public String join(User user) throws Exception {
		
		if(userRepository.findById(user.getUsername()) != null) {
			userRepository.save(user);			
		} else {
			throw new Exception();
		}
		
        return user.getUsername();
    }
	
	public List<User> getList(){
		return userRepository.findAll();
	}
	
	@Transactional
	@Override
	public int deleteUser(String username) {
		userRepository.deleteById(username);
		return 0;
	}
}
