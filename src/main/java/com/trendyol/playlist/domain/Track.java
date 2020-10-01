package com.trendyol.playlist.domain;

import lombok.Getter;
import lombok.Setter;

public class Track {
    @Getter @Setter private String name;
    @Getter @Setter private String artist;
    @Getter @Setter private String length;

    public Track(String name, String artist, String length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
    }

}
