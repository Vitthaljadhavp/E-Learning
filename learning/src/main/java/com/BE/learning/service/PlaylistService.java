package com.BE.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE.learning.entity.Content;
import com.BE.learning.entity.Playlist;
import com.BE.learning.repository.ContentRepository;
import com.BE.learning.repository.PlaylistRepository;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ContentRepository contentRepository;

    public Playlist getPlaylistDetails(Long playlistId, Long tutorId) {
        // Ensure the repository method returns Optional<Playlist>
        return playlistRepository.findByIdAndTutorId(playlistId, tutorId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public List<Content> getPlaylistVideos(Long tutorId, Long playlistId) {
        return contentRepository.findByTutorIdAndPlaylistId(tutorId, playlistId);
    }

    public void deletePlaylist(Long playlistId) {
        // Delete associated contents
        List<Content> contents = contentRepository.findByPlaylistId(playlistId);
        for (Content content : contents) {
            contentRepository.delete(content);
        }
        playlistRepository.deleteById(playlistId);
    }
}
