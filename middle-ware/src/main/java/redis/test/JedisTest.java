package redis.test;

import redis.clients.jedis.Jedis;

/**
 * @author yanmingkun
 * @date 2020-04-02 19:12
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("name","yanmingkun");
        jedis.close();
    }
}
