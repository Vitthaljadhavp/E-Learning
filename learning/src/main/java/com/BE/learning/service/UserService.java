package com.BE.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE.learning.entity.User;  // Ensure you are using the correct 'User' entity
import com.BE.learning.repository.UserRepository;  // Correct import for the repository

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Register a new user
    public void register(User newUser) {
        userRepository.save(newUser);  // Save the user to the repository
    }

    // Get user by ID
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update user
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

}
