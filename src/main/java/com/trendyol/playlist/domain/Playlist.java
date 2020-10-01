package com.trendyol.playlist.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Playlist {
    @Getter @Setter private String userId;
    @Getter private String playlistId;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private int followersCount;
    @Getter @Setter private List<Track> tracks;
    @Getter @Setter private int trackCount;


    public Playlist(){

    }

    public Playlist(String userId) {
        this.userId = userId;
    }

    public Playlist(String userId, String name, String description){
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.playlistId = UUID.randomUUID().toString();
        this.followersCount = 0;
        this.tracks = new ArrayList<>();
        this.trackCount = 0;
    }

    public void addTrack(Track trackToAdd) {
        this.tracks.add(trackToAdd);
        this.trackCount++;
    }

    public void removeTrack(Track trackToRemove) {
        this.tracks.remove(trackToRemove);
        this.trackCount--;
    }
}
