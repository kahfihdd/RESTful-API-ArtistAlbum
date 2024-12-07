package com.example.music_api.service;

import com.example.music_api.model.Artist;
import com.example.music_api.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }
}

