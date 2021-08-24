package tech.shuyi.javacodechip.spring_kafka_api;

import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Spring-Kafka 消费者 Demo
 * @author yurongchan
 */
@Component
@Log
public class ConsumerDemo {
    /**
     * 消费者类
     * @param msgData
     */
    @KafkaListener(id = "bmail-msg-topic", topics = "bmail-msg-topic")
    public void listen(String msgData) {
        log.info("demo receive : "+msgData);
    }
}