package com.hireapp.Auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hireapp.Auth.model.Users;
import com.hireapp.Auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users users = userRepository.findByUsername(username)
//            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//
//        // Assuming users.getRole() returns a comma-separated list of roles like "USER,ADMIN"
//        List<SimpleGrantedAuthority> authorities = Arrays.stream(users.getRole().split(","))
//            .map(role -> "ROLE_" + role.trim())  // Add ROLE_ prefix if not already there
//            .map(SimpleGrantedAuthority::new)
//            .collect(Collectors.toList());
//
//        // Return the user with authorities
//        return org.springframework.security.core.userdetails.User
//                .withUsername(users.getUsername())
//                .password(users.getPassword())
//                .authorities(authorities)
//                .build();
//    }
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user1 = userRepo.findByUsername(username);
		
		if(user1 == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrinciple(user1);
	}
}
