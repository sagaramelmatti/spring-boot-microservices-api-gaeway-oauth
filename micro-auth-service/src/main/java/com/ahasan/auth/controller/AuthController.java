package com.ahasan.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahasan.auth.dto.ApiResponse;
import com.ahasan.auth.dto.SignUpRequest;
import com.ahasan.auth.repository.UserDetailRepository;
import com.ahasan.auth.service.UserDetailServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private UserDetailRepository userRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailServiceImpl userDetailService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/signup")
	
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		
        if((userRepository.findByUsername(signUpRequest.getUsername()).isPresent())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if((userRepository.findByEmail(signUpRequest.getEmail()).isPresent())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        
        
        return userDetailService.registerUser(signUpRequest);
    }
}
