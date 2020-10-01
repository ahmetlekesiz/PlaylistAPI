package com.trendyol.playlist.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaylistTests {

    @Test
    public void should_create_playlist_by_getting_userId(){
        // Arrange
        String userId = "0001";

        // Act
        Playlist sut = new Playlist("0001");

        // Verify
        assertEquals(userId, sut.getUserId());
    }

    @Test
    public void should_add_track_to_playlist_by_playlistId(){
        // Arrange
        String userId = "0001";
        Playlist sut = new Playlist(userId, "Playlist For Test", "Description of the Playlist");
        Track trackToAdd = new Track("Break My Heart", "Dua Lipa", "180");

        // Act
        sut.addTrack(trackToAdd);

        // Verify
        assertEquals(sut.getTrackCount(), 1);
    }

    @Test
    public void should_remove_track_from_the_playlist(){
        // Arrange
        String userId = "0001";
        Playlist sut = new Playlist(userId, "Playlist For Test", "Description of the Playlist");
        Track trackToAdd1 = new Track("Break My Heart", "Dua Lipa", "180");
        Track trackToAdd2 = new Track("Are you mine?", "Arctic Monkeys", "176");
        sut.addTrack(trackToAdd1);
        sut.addTrack(trackToAdd2);

        // Act
        sut.removeTrack(trackToAdd1);

        // Verify
        assertEquals(sut.getTrackCount(), 1);
    }

}
