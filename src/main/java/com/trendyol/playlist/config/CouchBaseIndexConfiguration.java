package com.trendyol.playlist.config;

import com.couchbase.client.java.Cluster;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchBaseIndexConfiguration {

    private final Cluster couchbaseCluster;

    public CouchBaseIndexConfiguration(Cluster couchbaseCluster) {
        this.couchbaseCluster = couchbaseCluster;
    }

}
