package com.BE.learning.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ContactInquiry {
    private String name;
    private String email;
    private String message;

    // Getters and Setters
}
