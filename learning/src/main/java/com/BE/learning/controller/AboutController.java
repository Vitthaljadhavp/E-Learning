package com.BE.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Correct import for Model from Spring MVC
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("projectInfo", "Your project info here");
        return "about"; // about.html (Thymeleaf template)
    }
}
