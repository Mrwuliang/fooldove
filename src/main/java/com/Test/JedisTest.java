package com.Test;

import org.junit.Test;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Component("jedisTest")
public class JedisTest {
    @Resource(name = "jedis")
    private Jedis jedis;
    public String test(){
        String set = jedis.set("password2", "123456");
        jedis.close();
        return set;
    }
}
