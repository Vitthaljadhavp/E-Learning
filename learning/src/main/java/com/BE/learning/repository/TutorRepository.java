package com.BE.learning.repository;

import com.BE.learning.entity.Tutor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Optional<Tutor> findById(Long id);
}
