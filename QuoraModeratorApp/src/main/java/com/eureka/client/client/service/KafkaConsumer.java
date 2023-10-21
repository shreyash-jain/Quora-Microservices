package com.eureka.client.client.service;

import com.eureka.client.client.model.QuoraPost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private PostService postService;

    private final KafkaTemplate<String, QuoraPost> kafkaTemplate;

    @KafkaListener(topics = "yoyo",
            groupId = "group-id")
    public void consume(String postJson)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            QuoraPost map = mapper.readValue(postJson, QuoraPost.class);
            log.info(String.format("Post consumed -> %s", map.toString()));
            postService.moderatePost(map);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

