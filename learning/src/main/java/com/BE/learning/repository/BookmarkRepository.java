package com.BE.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Playlist;

@Repository
public interface BookmarkRepository extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findByIdAndTutorId(Long id, Long tutorId);
}
