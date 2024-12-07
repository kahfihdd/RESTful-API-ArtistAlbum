package com.example.music_api.service;

import com.example.music_api.model.Album;
import com.example.music_api.model.Artist;
import com.example.music_api.repository.AlbumRepository;
import com.example.music_api.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album updatedAlbum) {
        // Cari album berdasarkan ID
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        // Cari artis berdasarkan ID untuk memuat data lengkap
        Artist artist = artistRepository.findById(updatedAlbum.getArtist().getId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        // Update properti album
        album.setName(updatedAlbum.getName());
        album.setReleaseYear(updatedAlbum.getReleaseYear());
        album.setArtist(artist);

        // Simpan perubahan
        return albumRepository.save(album);
    }


    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
