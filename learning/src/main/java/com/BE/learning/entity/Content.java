package com.BE.learning.entity;

import java.util.List;

import jakarta.persistence.OneToMany;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.GenerationType;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import lombok.Data;

import jakarta.persistence.Table;

import jakarta.persistence.Entity;

@Entity
@Table(name = "content")
@Data // Lombok's annotation automatically generates getters and setters for all fields
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String video;
    private String thumb;
    private String date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @OneToMany(mappedBy = "content")
    private List<Comment> comments;

    @OneToMany(mappedBy = "content")
    private List<Like> likes;

    // No need to manually define setters as @Data generates them
}
