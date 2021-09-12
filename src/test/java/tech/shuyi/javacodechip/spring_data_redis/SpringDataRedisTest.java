package tech.shuyi.javacodechip.spring_data_redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tech.shuyi.javacodechip.redis.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test() {
        User user = new User();
        user.setAge(10);
        user.setName("Ronald");
        redisTemplate.opsForValue().set("ronald", user);
        System.out.println(redisTemplate.opsForValue().get("ronald").toString());
    }
}