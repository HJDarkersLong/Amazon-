package com.heeexy.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YmlConfig {

    @Value("${spring.redis.host:#{null}}")
    private String host;

    @Value("${dir:#{null}}")
    private String dir;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
