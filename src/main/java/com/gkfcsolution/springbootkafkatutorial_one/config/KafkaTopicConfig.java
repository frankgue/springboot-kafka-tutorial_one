package com.gkfcsolution.springbootkafkatutorial_one.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created on 2025 at 17:38
 * File: null.java
 * Project: springboot-kafka-tutorial_one
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 17:38
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic gkfcsolutionTopic(){
        return TopicBuilder.name("${spring.kafka.topic.name}")
                .build();
    }

    @Bean
    public NewTopic gkfcsolutionJsonTopic(){
        return TopicBuilder.name("${spring.kafka.topic.name.json}")
                .build();
    }
}
