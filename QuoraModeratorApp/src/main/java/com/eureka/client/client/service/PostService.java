package com.eureka.client.client.service;



import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;

import java.util.List;

public interface PostService {

    void moderatePost(QuoraPost post);
}
