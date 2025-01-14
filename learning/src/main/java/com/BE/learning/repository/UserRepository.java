package com.BE.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BE.learning.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
}
