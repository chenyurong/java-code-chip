package tech.shuyi.javacodechip.spring_kafka_api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerDemoTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testDemo() throws InterruptedException {
        kafkaTemplate.send("bmail-msg-topic", "this is my first demo" + Math.random());
        //休眠5秒，为了使监听器有足够的时间监听到topic的数据
        Thread.sleep(5000);
    }
}