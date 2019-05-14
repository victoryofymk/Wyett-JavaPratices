package com.it.ymk.springboot.starter.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yanmingkun
 * @date 2019-03-29 14:19
 */
@ConfigurationProperties(prefix = "redis.starter")
public class RedisProperties {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
