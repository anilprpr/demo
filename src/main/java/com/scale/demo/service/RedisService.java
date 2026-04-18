package com.scale.demo.service;

import com.scale.demo.config.RedisConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisConfig redis;

    public String getMykeyJsonPayload(String key)
    {
        log.info("My Redis Key:{}",key);
        return redis.getValue(key);

    }
    public void setMykeyValue(String key, String value)
    {
        log.info("My Redis SET Key:{}:{}",key,value);
        redis.setValue(key, value);

    }

}
