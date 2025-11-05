package com.gkfcsolution.springbootkafkatutorial_one.controller;

import com.gkfcsolution.springbootkafkatutorial_one.service.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 17:59
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 17:59
 */
@RestController
@RequestMapping("/api/v1/kafka")
@Slf4j
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        log.info("Inside publish method");
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
