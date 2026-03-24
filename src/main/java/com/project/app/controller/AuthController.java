package com.project.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.User;
import com.project.app.service.UserService;
import com.project.app.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	  
	  
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
	    userService.register(user);
	    return new ResponseEntity<>("User Registered Successfully",HttpStatus.CREATED);
	}  
	 
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody User user) {
	        try {
	            Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
	            );

	            if (authentication.isAuthenticated()) {
	                String token = jwtUtil.generateToken(user.getUsername());
	                return ResponseEntity.ok().body("JWT Token: " + token);
	            }
	        } catch (AuthenticationException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
	    }
	    
}