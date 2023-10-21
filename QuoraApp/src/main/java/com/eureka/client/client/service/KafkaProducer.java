package com.eureka.client.client.service;

import com.eureka.client.client.model.QuoraPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, QuoraPost> kafkaTemplate;

    public void send(QuoraPost message){
        log.info("Payload : {}", message);
        kafkaTemplate.send(topicName, message);
    }
}

