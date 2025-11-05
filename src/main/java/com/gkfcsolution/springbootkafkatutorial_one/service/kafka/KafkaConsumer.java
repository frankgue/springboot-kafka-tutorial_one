package com.gkfcsolution.springbootkafkatutorial_one.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 18:48
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 18:48
 */
@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String message){
        log.info("Message received => {}", message);
    }
}
