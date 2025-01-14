package com.BE.learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

    // Getters and Setters
}
