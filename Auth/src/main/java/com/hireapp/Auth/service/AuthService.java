package com.hireapp.Auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hireapp.Auth.dto.AuthRequest;
import com.hireapp.Auth.dto.AuthResponse;
import com.hireapp.Auth.dto.RegisterRequest;
import com.hireapp.Auth.model.Users;
import com.hireapp.Auth.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	

	public Users register(RegisterRequest request) {
	    Users user = new Users(); // Create your entity
	    user.setUsername(request.getUsername());
	    user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode the password
	    user.setRole(request.getRole()); // Set the role

	    return userRepository.save(user); // Now you are saving your JPA entity
//
//	    var jwtToken = jwtService.generateToken(user.getUsername());
//	    AuthResponse authResponse = new AuthResponse();
//	    authResponse.setToken(jwtToken);
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepository.save(user);
	    
	}
	
	public String login(AuthRequest auth) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
		//var user = userRepository.findByUsername(auth.getUsername());
		if(authentication.isAuthenticated()) {
			var token = jwtService.generateToken(auth.getUsername());
			
			AuthResponse response = new AuthResponse();
			response.setToken(token);
			
			return response.getToken();
		}
		return "failed";
		
	}

}
