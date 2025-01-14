package com.BE.learning.service;

import org.springframework.stereotype.Service;

@Service
public class VideoService {

    // Method to fetch the video URL from the database
    public String getVideoUrl(Long videoId) {
        // Logic to fetch the video URL from the database using videoId
        // Example URL, replace with actual database logic
        return "http://path/to/video/" + videoId;
    }
}
