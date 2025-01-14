package com.BE.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.BE.learning.entity.Content;
import com.BE.learning.repository.CommentRepository;
import com.BE.learning.repository.ContentRepository;
import com.BE.learning.repository.LikeRepository;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    // Get content details based on contentId and tutorId
    public Content getContentDetails(Long contentId, Long tutorId) {
        return contentRepository.findByIdAndTutorId(contentId, tutorId)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }

    // Add new content with title, description, video file, etc.
    public void addContent(String title, String description, MultipartFile videoFile, MultipartFile thumbFile, String date, String status) {
        try {
            // Save the video and thumbnail files and get the file paths
            String videoPath = saveVideoFile(videoFile);
            String thumbPath = saveThumbFile(thumbFile);

            // Create new content object and set properties
            Content content = new Content();
            content.setTitle(title);
            content.setDescription(description);
            content.setVideo(videoPath);
            content.setThumb(thumbPath);
            content.setDate(date);
            content.setStatus(status);

            // Save content to the repository
            contentRepository.save(content);
        } catch (Exception e) {
            throw new RuntimeException("Error uploading content", e);
        }
    }

    // Update existing content
    public void updateContent(Content updatedContent) {
        contentRepository.save(updatedContent);
    }

    // Delete content and associated comments and likes
    public void deleteContent(Long contentId) {
        // Delete associated comments and likes
        commentRepository.deleteByContentId(contentId);
        likeRepository.deleteByContentId(contentId);
        
        // Delete the content itself
        contentRepository.deleteById(contentId);
    }

    // Search for content based on search query (title or description)
    public List<Content> searchContents(String searchQuery) {
        return contentRepository.findByTitleContainingOrDescriptionContaining(searchQuery, searchQuery);
    }

    // Helper method to save video file
    private String saveVideoFile(MultipartFile videoFile) {
        // Code to save the video file to a directory or cloud storage
        return "path/to/video/" + videoFile.getOriginalFilename();
    }

    // Helper method to save thumbnail file
    private String saveThumbFile(MultipartFile thumbFile) {
        // Code to save the thumbnail file to a directory or cloud storage
        return "path/to/thumbnail/" + thumbFile.getOriginalFilename();
    }
}
