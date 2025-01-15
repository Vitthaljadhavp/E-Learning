package com.BE.learning.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContactInquiry {
    private String name;
    private String email;
    private String message;

    // Getters and Setters
}
