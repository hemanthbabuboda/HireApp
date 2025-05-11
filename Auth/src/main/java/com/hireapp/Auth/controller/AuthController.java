package com.hireapp.Auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hireapp.Auth.dto.AuthRequest;
import com.hireapp.Auth.dto.AuthResponse;
import com.hireapp.Auth.dto.RegisterRequest;
import com.hireapp.Auth.model.Users;
import com.hireapp.Auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Users> register(@RequestBody RegisterRequest request){
		return new ResponseEntity<Users>( authService.register(request), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> register(@RequestBody AuthRequest request){
		return new ResponseEntity<String>(authService.login(request),HttpStatus.OK);
	}
	
}
