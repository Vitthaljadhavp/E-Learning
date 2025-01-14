package com.BE.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE.learning.entity.Faq;
import com.BE.learning.repository.FaqRepository;

import java.util.List;

@Service
public class FaqService {

    @Autowired
    private FaqRepository faqRepository; // Injecting the FAQ repository

    public List<Faq> getAllFaqs() {
        return faqRepository.findAll(); // Fetch all FAQs from the database
    }
}
