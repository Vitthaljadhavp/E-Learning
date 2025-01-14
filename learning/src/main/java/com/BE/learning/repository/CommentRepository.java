package com.BE.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE.learning.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByContentId(Long contentId);
    void deleteByContentId(Long contentId); // Add this method to delete comments by content ID
}

