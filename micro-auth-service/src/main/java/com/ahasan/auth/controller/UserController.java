package com.ahasan.auth.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahasan.auth.dto.UserProfile;
import com.ahasan.auth.exception.ResourceNotFoundException;
import com.ahasan.auth.model.AuthUserDetail;
import com.ahasan.auth.model.User;
import com.ahasan.auth.repository.UserDetailRepository;
import com.ahasan.auth.seurity.CurrentUser;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDetailRepository userRepository;

    @GetMapping("/me")
    public User getCurrentUser(@CurrentUser AuthUserDetail currentUser) {
    	
    	return userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getId()));
    }
    
    
    @GetMapping("/profile/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user.getId().toString(), user.getUsername(), user.getUsername(), user.getEmail());

        return userProfile;
    }
    
    
}