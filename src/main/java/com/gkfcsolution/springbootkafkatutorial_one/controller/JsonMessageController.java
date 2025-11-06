package com.gkfcsolution.springbootkafkatutorial_one.controller;

import com.gkfcsolution.springbootkafkatutorial_one.entity.User;
import com.gkfcsolution.springbootkafkatutorial_one.service.kafka.JsonKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 11:02
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 06/11/2025
 * @time 11:02
 */
@RestController
@RequestMapping("/api/v1/kafka")
@Slf4j
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        log.info("inside publish post method");
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
