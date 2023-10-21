package com.sample_project.userApp.controller;


import com.sample_project.userApp.dto.UserDto;
import com.sample_project.userApp.model.User;
import com.sample_project.userApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> showAllUsers(){
        return new ResponseEntity<List<User>>(service.showAll(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> userById(@PathVariable("id") Long id){
        return new ResponseEntity<User>(service.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserDto user){
        System.out.println("Called - User/addUser ");
        System.out.println(user.toString());
        return new ResponseEntity(service.addUser(user),HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<String>(service.deleteUser(id),HttpStatus.ACCEPTED);
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
            @RequestBody UserDto user){
        return new ResponseEntity<User>(service.updateUser(id,user),HttpStatus.ACCEPTED);

    }

}
