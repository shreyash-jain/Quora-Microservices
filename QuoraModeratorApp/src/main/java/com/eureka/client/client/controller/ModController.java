package com.eureka.client.client.controller;

import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;
import com.eureka.client.client.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/moderate")
public class ModController {
    @Autowired
    private PostService postService;

    @PostMapping(value = "/blog")
    ResponseEntity<String> moderateBlog(@RequestBody QuoraPost postDto){
        try {

            postService.moderatePost(postDto);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
        }
        return ResponseEntity.ok().body("passed");
    }
}
