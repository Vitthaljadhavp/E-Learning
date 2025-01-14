package com.BE.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Correct import for the Model class
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BE.learning.entity.ContactInquiry;

@Controller
public class ContactController {
    
    @GetMapping("/contact")
    public String getContactPage(Model model) {
        model.addAttribute("contactInfo", "Your contact info here");
        return "contact"; // contact.html (Thymeleaf template)
    }

    @PostMapping("/contact")
    public ResponseEntity<String> submitInquiry(@RequestBody ContactInquiry inquiry) {
        // Process the inquiry (e.g., save to database, send email, etc.)
        return ResponseEntity.ok("Inquiry submitted successfully");
    }
}
