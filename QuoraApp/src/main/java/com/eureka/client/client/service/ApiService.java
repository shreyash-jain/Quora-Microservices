package com.eureka.client.client.service;

import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ApiService {

    @Autowired
    RestTemplate restTemplate;


    Boolean sendDataToModeratorViaApi(QuoraPost postDto){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<QuoraPost> entity = new HttpEntity<>(postDto, headers);

            ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8086/moderate/blog", entity, String.class);
            log.info(result.toString());
            return result.getStatusCode().is2xxSuccessful();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
