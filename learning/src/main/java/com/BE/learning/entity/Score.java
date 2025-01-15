package com.BE.learning.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Score {
    private int score;
}
