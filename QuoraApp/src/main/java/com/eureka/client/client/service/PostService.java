package com.eureka.client.client.service;



import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;

import java.util.List;

public interface PostService {

    List<QuoraPost> showAll();

    List<QuoraPost> getPostByUserId(Long id);

    String addPost(QuoraPostDto post);

    String deletePost(String id);

    QuoraPost updatePost(String id, QuoraPostDto post);
}
