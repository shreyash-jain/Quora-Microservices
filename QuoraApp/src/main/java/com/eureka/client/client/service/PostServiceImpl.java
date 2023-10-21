package com.eureka.client.client.service;

import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;
import com.eureka.client.client.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    private Repository repository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private ApiService apiService;


    @Override
    public List<QuoraPost> showAll() {

        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<QuoraPost> getPostByUserId(Long id) {
        List<QuoraPost> result = new ArrayList<QuoraPost>();

        try {
            if(!repository.existsByUserId(id)){
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return repository.findByUserId(id);
    }

    @Override
    public String addPost(QuoraPostDto post) {
        try {

            QuoraPost u = new QuoraPost();
            u.setTitle(post.getTitle());
            u.setUserId(post.getUserid());
            u.setBody(post.getBody());

            repository.save(u);
            kafkaProducer.send(u);
            //Boolean b = apiService.sendDataToModeratorViaApi(u);
            //log.info(b.toString());
            return "Post Added!!";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    @Override
    public String deletePost(String id) {
        try {
            repository.deleteById(id);
            return "Successfully deleted post with ID = " + id;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public QuoraPost updatePost(String id, QuoraPostDto inputPost) {

        Optional<QuoraPost> obj = repository.findById(id);
        if (obj.isPresent()) {
            QuoraPost post = obj.get();
            if ((inputPost.getTitle() != null)) {
                post.setTitle(inputPost.getTitle());
            }
            if ((inputPost.getBody() != null)) {
                post.setBody(inputPost.getBody());
            }
            if ((inputPost.getUserid() != null)) {
                post.setUserId(inputPost.getUserid());
            }

            return repository.save(post);

        } else {
            throw new NullPointerException();
        }

    }
}
