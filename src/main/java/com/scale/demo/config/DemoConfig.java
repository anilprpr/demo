package com.scale.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Value("${redis.ip:127.0.0.1}")
    private String ip;
    @Value("${redis.port:6379}")
    private int port;

    @Bean
    public RedisConfig  getRedis()
    {
        return  RedisConfig.getInstance(ip,port);

    }
}
