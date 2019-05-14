package com.it.ymk.springboot.starter.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * @author yanmingkun
 * @date 2019-03-29 14:32
 */
@SpringBootApplication
@EnableRedis
public class RedisDistributedLockStarterDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run
                        (RedisDistributedLockStarterDemoApplication.class, args);
        Jedis jedis = context.getBean(Jedis.class);
        jedis.set("name", "snowalker");
        jedis.setex("snowalker", 10, "snowalker");
        System.out.println(jedis.get("name"));
        context.close();
    }
}
