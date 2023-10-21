package com.eureka.client.client.service;

import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.filterService.Moderator;
import com.eureka.client.client.filterService.SimpleFilter;
import com.eureka.client.client.model.QuoraPost;
import com.eureka.client.client.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    private Repository repository;


    @Override
    public void moderatePost(QuoraPost post) {
        Moderator moderator = new Moderator(Arrays.asList(new SimpleFilter(Arrays.asList("Shit", "Poo", "bitch", "bloody"))));
        post.setBody(moderator.moderate(post.getBody()));
        repository.save(post);
        log.info(post.toString());
    }
}
