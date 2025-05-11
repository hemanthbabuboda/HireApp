package com.hireapp.Auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireapp.Auth.dto.RegisterRequest;
import com.hireapp.Auth.model.Users;
import com.hireapp.Auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Users register(RegisterRequest request) {
		Users users = new Users();
		users.setUsername(request.getUsername());
		users.setPassword(request.getPassword());
		users.setRole(request.getRole());
		
		return userRepository.save(users);
	}
	
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
