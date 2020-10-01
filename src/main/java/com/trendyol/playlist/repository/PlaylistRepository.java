package com.trendyol.playlist.repository;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.playlist.domain.Playlist;
import com.trendyol.playlist.domain.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {
    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void create(Playlist playlist) {
        playlistCollection.insert(playlist.getPlaylistId(), playlist);
    }

    public void findPlaylistById(String playlistId) {
        playlistCollection.get(playlistId);
    }

    public void deletePlaylistById(String playlistId) {
        playlistCollection.remove(playlistId);
    }

    public List<Playlist> findAllByUserId(String userId) {
        String statement = String.format("Select * from playlist where userId = '%s'", userId);
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }

    public void addTrackToPlaylist(String playlistId, Track track) {
        GetResult playlistResult = playlistCollection.get(playlistId);
        Playlist playlistObject = playlistResult.contentAs(Playlist.class);
        playlistObject.addTrack(track);
        playlistCollection.replace(playlistId, playlistObject);
    }

    public void deleteTrackFromPlaylist(String playlistId, Track track) {
        GetResult playlistResult = playlistCollection.get(playlistId);
        Playlist playlistObject = playlistResult.contentAs(Playlist.class);
        playlistObject.removeTrack(track);
        playlistObject.setTrackCount(playlistObject.getTrackCount()-1);
        playlistCollection.replace(playlistId, playlistObject);
    }
}
