package com.BE.learning.controller;

import com.BE.learning.entity.Tutor;
import com.BE.learning.entity.User; // Ensure you're importing the correct 'User' entity
import com.BE.learning.service.TutorService;
import com.BE.learning.service.UserService;  // Correct import for UserService

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private TutorService tutorService;
    
    @Autowired
    private UserService userService;  // Injecting UserService

    // View tutor profile
    @GetMapping("/profile")
    public String viewProfile(Model model, Long tutorId) {
        Tutor tutor = tutorService.getTutorProfile(tutorId);
        model.addAttribute("tutor", tutor);
        return "profile";
    }

    // Get user profile (for User entity)
    @GetMapping("/profiles")
    public User getProfile(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

    // Update user profile (for User entity)
    @PutMapping("/profiles")
    public ResponseEntity<String> updateProfile(@RequestBody User updatedUser) {
        userService.updateUser(updatedUser);
        return ResponseEntity.ok("Profile updated successfully");
    }
}
