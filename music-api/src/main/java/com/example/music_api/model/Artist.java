package com.example.music_api.model;

import jakarta.persistence.*;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean verifiedUser;

    @Column(nullable = false)
    private String genre;

    // Getters dan Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isVerifiedUser() { return verifiedUser; }
    public void setVerifiedUser(boolean verifiedUser) { this.verifiedUser = verifiedUser; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
