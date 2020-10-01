package com.trendyol.playlist.controller;

import com.trendyol.playlist.domain.Playlist;
import com.trendyol.playlist.domain.Track;
import com.trendyol.playlist.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody Playlist playlist, @RequestParam String userId){
        playlist.setUserId(userId);
        this.playlistService.createPlaylist(playlist);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Void> findPlaylistById(@PathVariable String playlistId){
        playlistService.findPlaylistById(playlistId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylistById(@PathVariable String playlistId){
        playlistService.deletePlaylistById(playlistId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/userId")
    public ResponseEntity<List<Playlist>> findAllByUserId(@RequestParam String userId){
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }


    @PostMapping("/{playlistId}/track")
    public ResponseEntity<Void> addTrackToPlaylist(@PathVariable String playlistId, Track track){
        playlistService.addTrackToPlaylist(playlistId,track);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{playlistId}/track")
    public ResponseEntity<Void> deleteTrackFromPlaylist(@PathVariable String playlistId, @RequestBody Track track){
        playlistService.deleteTrackFromPlaylist(playlistId, track);
        return ResponseEntity.ok().build();
    }
}
