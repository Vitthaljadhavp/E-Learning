package com.BE.learning.service;

import com.BE.learning.entity.Tutor;
import com.BE.learning.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor getTutorProfile(Long tutorId) {
        return tutorRepository.findById(tutorId).orElse(null);
    }
}
