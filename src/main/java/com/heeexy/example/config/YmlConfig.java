package com.heeexy.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YmlConfig {

    @Value("${spring.redis.host:#{null}}")
    private String host;

    @Value("${uploadDir:#{null}}")
    private String uploadDir;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
