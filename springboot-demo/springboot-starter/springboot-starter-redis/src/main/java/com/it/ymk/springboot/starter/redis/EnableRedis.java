package com.it.ymk.springboot.starter.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yanmingkun
 * @date 2019-03-29 14:49
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedisAutoConfiguration.class)
public @interface EnableRedis {
}
