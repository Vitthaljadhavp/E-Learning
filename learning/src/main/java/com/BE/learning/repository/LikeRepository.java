package com.BE.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Long countByContentId(Long contentId);
    Optional<Like> findByTutorIdAndContentId(Long tutorId, Long contentId);
    void deleteByContentId(Long contentId); // Add this method to delete likes by content ID

}

