package com.BE.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to the platform");
        return "home"; // home.html (Thymeleaf template)
    }
}

