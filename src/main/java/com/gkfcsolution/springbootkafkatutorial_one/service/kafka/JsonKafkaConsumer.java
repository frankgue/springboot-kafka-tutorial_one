package com.gkfcsolution.springbootkafkatutorial_one.service.kafka;

import com.gkfcsolution.springbootkafkatutorial_one.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 11:22
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 11:22
 */
@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topic.name.json}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(User user){
        log.info("Json message reveived => {}", user.toString());
    }
}
