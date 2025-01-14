package com.BE.learning.controller;

import com.BE.learning.entity.User;  // Make sure to import the correct 'User' entity
import com.BE.learning.service.UserService;  // Import the correct UserService

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;  // Correctly inject UserService

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        userService.register(newUser);  // Call the 'register' method in UserService
        return ResponseEntity.ok("User registered successfully");
    }
}
