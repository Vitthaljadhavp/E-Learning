package com.BE.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
