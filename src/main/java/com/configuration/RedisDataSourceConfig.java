package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class RedisDataSourceConfig {
    @Bean("redisProperties")
    public Properties redisProperty() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = RedisDataSourceConfig.class.getClassLoader().getResourceAsStream("redis.properties");
        properties.load(resourceAsStream);
        return properties;
    }

    @Resource(name = "redisProperties")
    private Properties redisProperties;

    //redis¡¨Ω”≥ÿ
    @Bean("jedis")
    public Jedis getJedis(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(redisProperties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(redisProperties.getProperty("maxIdle")));
        JedisPool jedisPool = new JedisPool(redisProperties.getProperty("ip"), Integer.parseInt(redisProperties.getProperty("port")));
        return jedisPool.getResource();
    }
}
