package com.sb.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
    public String join(User user) {
        userRepository.save(user);
        return user.getUsername();
    }
}
