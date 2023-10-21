package com.eureka.client.client.controller;


import com.eureka.client.client.dto.QuoraPostDto;
import com.eureka.client.client.model.QuoraPost;
import com.eureka.client.client.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userspost")
public class Controller {

    @Autowired
    PostService service;

    @GetMapping("/getAllPost")
    public ResponseEntity<List<QuoraPost>> getAllGloQuora_Post() {
        return new ResponseEntity<List<QuoraPost>>(service.showAll(), HttpStatus.OK);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<List<QuoraPost>> getGloQuora_PostById(@PathVariable("id") Long id) {
        return new ResponseEntity<List<QuoraPost>>(service.getPostByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody QuoraPostDto post) {
        return new ResponseEntity(service.addPost(post), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") String id) {
        return new ResponseEntity<String>(service.deletePost(id), HttpStatus.ACCEPTED);
    }


    @PostMapping("/updatePost/{id}")
    public ResponseEntity<QuoraPost> updatePost(@PathVariable("id") String id,
                                                @RequestBody QuoraPostDto post) {
        return new ResponseEntity<QuoraPost>(service.updatePost(id, post), HttpStatus.ACCEPTED);

    }
}
