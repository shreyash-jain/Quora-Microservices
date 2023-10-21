package com.eureka.client.client.repository;

import com.eureka.client.client.model.QuoraPost;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface Repository extends MongoRepository<QuoraPost,String> {
    public List<QuoraPost> findByUserId(Long userId);

    public Boolean existsByUserId(Long id);
}
