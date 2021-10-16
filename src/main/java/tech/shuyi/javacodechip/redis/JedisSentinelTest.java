package tech.shuyi.javacodechip.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JedisSentinelTest {
    public static void main(String[] args) throws Exception {
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("127.0.0.1:6800");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = null;
        while (true) {
            Thread.sleep(1000);

            try {
                jedis = jedisSentinelPool.getResource();

                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String format_now = dateFormat.format(now);

                jedis.set("hello", "world");
                String value = jedis.get("hello");
                System.out.println(format_now + ' ' + value);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (jedis != null) {
                    try {
                        jedis.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}