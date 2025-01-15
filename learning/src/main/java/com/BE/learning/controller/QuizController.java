package com.BE.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BE.learning.entity.Score;

@RestController
public class QuizController {
    @GetMapping("/")
    public String home() {
        return "index";  // This will serve the index.html located in the static folder
    }

    @PostMapping("/submitScore")
    public ResponseEntity<String> submitScore(@RequestBody Score score) {
        // Process score (e.g., save to database, etc.)
        return ResponseEntity.ok("Score submitted");
    }
}
