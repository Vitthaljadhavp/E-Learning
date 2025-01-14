package com.BE.learning.controller;

import com.BE.learning.service.VideoService;  // Import the VideoService

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;  // Inject VideoService

    @GetMapping("/watch-video")
    public ResponseEntity<String> watchVideo(@RequestParam Long videoId) {
        String videoUrl = videoService.getVideoUrl(videoId);  // Fetch video URL from the database
        return ResponseEntity.ok(videoUrl);
    }
}
