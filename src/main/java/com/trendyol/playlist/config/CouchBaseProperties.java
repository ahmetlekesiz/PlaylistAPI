package com.trendyol.playlist.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties (prefix = "couchbase")
public class CouchBaseProperties {
    @Getter @Setter private String host;
    @Getter @Setter private String userName;
    @Getter @Setter private String password;
    @Getter @Setter private String bucketName;
}