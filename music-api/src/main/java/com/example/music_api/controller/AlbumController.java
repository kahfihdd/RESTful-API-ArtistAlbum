package com.example.music_api.controller;

import com.example.music_api.model.Album;
import com.example.music_api.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album albumDetails) {
        return albumService.updateAlbum(id, albumDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }
}

