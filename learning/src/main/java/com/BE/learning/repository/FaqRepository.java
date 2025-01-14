package com.BE.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
    // You can add custom query methods here if needed
}
