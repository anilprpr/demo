package com.scale.demo.config;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class RedisConfig {

    private static JedisPool jedisPool;
    private static volatile RedisConfig instance = null;

    private RedisConfig(String ip, int port) {
        try {
            if (jedisPool == null) {
                jedisPool = new JedisPool(new URI("http://" + ip + ":" + port));
            }
        } catch (URISyntaxException e) {
            log.error("Malformed server address", e);
        }
    }
    public static RedisConfig getInstance(String ip, final int port) {
        if (instance == null) {
            synchronized (RedisConfig.class) {
                if (instance == null) {
                    instance = new RedisConfig(ip, port);
                }
            }
        }
        return instance;
    }
    public List lrange(final String key, final long start, final long stop) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.lrange(key, start, stop);
        } catch (Exception ex) {
            log.info("Exception caught in lrange:{}", ex.getMessage());
        }
        return new LinkedList();
    }
    public String getValue(final String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception ex) {
            log.info("Exception caught in GET:{}", ex.getMessage());
        }
        return null;
    }
    public void setValue(final String key,final String value) {
        try (Jedis jedis = jedisPool.getResource()) {
             jedis.set(key,value);
        } catch (Exception ex) {
            log.info("Exception caught in SET:{}", ex.getMessage());
        }
        //return null;
    }
}
