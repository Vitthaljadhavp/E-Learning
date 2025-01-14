package com.BE.learning.controller;

import com.BE.learning.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SearchController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/search")
    public String search(@RequestParam("search") String searchQuery, Model model) {
        // Assume ContentService returns a list of content based on search
        model.addAttribute("searchResults", contentService.searchContents(searchQuery));
        return "searchResults";
    }
}
