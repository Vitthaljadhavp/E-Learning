package com.BE.learning.controller;

import com.BE.learning.service.UserService;  // Correct import for UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/account")
    public com.BE.learning.entity.User getAccount(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/account")
    public ResponseEntity<String> updateAccount(@RequestBody com.BE.learning.entity.User updatedUser) {
        userService.updateUser(updatedUser);
        return ResponseEntity.ok("Account updated successfully");
    }
}
