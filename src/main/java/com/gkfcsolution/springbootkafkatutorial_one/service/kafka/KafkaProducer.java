package com.gkfcsolution.springbootkafkatutorial_one.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 17:52
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 17:52
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${spring.kafka.topic.name}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Message sent {}", message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
