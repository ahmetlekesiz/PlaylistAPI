package com.trendyol.playlist.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrackTests {

    @Test
    public void should_create_track_with_given_parameters(){
        // Arrange
        String name = "Arctic Monkeys";
        String artist = "Are u mine?";
        String length = "176";

        // Act
        Playlist sut = new Playlist(artist, name, length);

        // Verify
        assertEquals("Arctic Monkeys", sut.getName());
    }
}
