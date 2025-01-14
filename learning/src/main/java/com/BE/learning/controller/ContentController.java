package com.BE.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BE.learning.entity.Content;
import com.BE.learning.service.ContentService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContent(@PathVariable Long id, @RequestParam Long tutorId) {
        Content content = contentService.getContentDetails(id, tutorId);
        return ResponseEntity.ok(content);
    }

    @PostMapping("/add-content")
    public ResponseEntity<String> addContent(@RequestParam String title, 
                                             @RequestParam String description, 
                                             @RequestParam MultipartFile videoFile, 
                                             @RequestParam MultipartFile thumbFile,
                                             @RequestParam String date,
                                             @RequestParam String status) {
        contentService.addContent(title, description, videoFile, thumbFile, date, status);
        return ResponseEntity.ok("Content added successfully");
    }

    @PutMapping("/edit-content")
    public ResponseEntity<String> editContent(@RequestBody Content updatedContent) {
        contentService.updateContent(updatedContent);
        return ResponseEntity.ok("Content updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Content>> searchContent(@RequestParam String query) {
        List<Content> results = contentService.searchContents(query);
        return ResponseEntity.ok(results);
    }
}
