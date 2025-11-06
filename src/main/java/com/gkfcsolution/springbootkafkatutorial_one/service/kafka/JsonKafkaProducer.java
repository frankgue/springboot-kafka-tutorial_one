package com.gkfcsolution.springbootkafkatutorial_one.service.kafka;

import com.gkfcsolution.springbootkafkatutorial_one.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 10:56
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 10:56
 */
@Service
@Slf4j
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic.name.json}")
    private String TopicName;
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, TopicName)
                .build();
        log.info("Message sent => {}", data.toString());
        kafkaTemplate.send(message);
    }
}
