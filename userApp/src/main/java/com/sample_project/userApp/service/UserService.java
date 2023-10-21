package com.sample_project.userApp.service;

import com.sample_project.userApp.dto.UserDto;
import com.sample_project.userApp.model.User;

import java.util.List;


public interface UserService {

    List<User> showAll();

    User getUserById(Long id);

    String addUser(UserDto user);

    String deleteUser(Long id);

    User updateUser(Long id, UserDto user);
}
