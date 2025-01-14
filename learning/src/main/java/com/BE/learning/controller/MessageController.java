package com.BE.learning.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    public String displayMessages(Model model) {
        // Add sample message to Model
        model.addAttribute("message", "This is a sample message!");
        return "dashboard";
    }
}

