package com.BE.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByTutorIdAndPlaylistId(Long tutorId, Long playlistId);
    Optional<Content> findByIdAndTutorId(Long id, Long tutorId);
    List<Content> findByPlaylistId(Long playlistId);
    List<Content> findByTitleContainingOrDescriptionContaining(String title, String description);  // Search by title or description
}
