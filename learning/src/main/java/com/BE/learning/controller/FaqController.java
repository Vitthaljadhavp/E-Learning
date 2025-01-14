package com.BE.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE.learning.service.FaqService;
import com.BE.learning.entity.Faq;

import java.util.List;

@RestController
public class FaqController {

    @Autowired
    private FaqService faqService;

    @GetMapping("/faq")
    public List<Faq> getFaqs() {
        return faqService.getAllFaqs(); 
    }
}
