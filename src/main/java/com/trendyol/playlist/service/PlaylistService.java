package com.trendyol.playlist.service;

import com.trendyol.playlist.domain.Playlist;
import com.trendyol.playlist.domain.Track;
import com.trendyol.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    public void createPlaylist(Playlist playlist) {
        this.playlistRepository.create(playlist);
    }

    public void findPlaylistById(String playlistId) {
        this.playlistRepository.findPlaylistById(playlistId);
    }

    public void deletePlaylistById(String playlistId) {
        this.playlistRepository.deletePlaylistById(playlistId);
    }

    public List<Playlist> findAllByUserId(String userId) {
        return this.playlistRepository.findAllByUserId(userId);
    }

    public void addTrackToPlaylist(String playlistId, Track track) {
        this.playlistRepository.addTrackToPlaylist(playlistId, track);
    }

    public void deleteTrackFromPlaylist(String playlistId, Track track) {
        this.playlistRepository.deleteTrackFromPlaylist(playlistId, track);
    }
}
