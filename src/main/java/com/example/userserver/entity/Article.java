package com.example.userserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    private ColorArticle color;

    public Article(String text, ColorArticle color) {
        this.text = text;
        this.color = color;
    }
}
