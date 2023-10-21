package com.sample_project.userApp.service;

import com.sample_project.userApp.dto.UserDto;
import com.sample_project.userApp.model.User;
import com.sample_project.userApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> showAll() {

        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addUser(UserDto user) {
        try {
            User u = new User(
                    user.getId(),
                    user.getName(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getPhone(),user.getCompany()
            );
            System.out.println(u.toString());
            repository.save(u);
            return "User Added!!";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    @Override
    public String deleteUser(Long id) {
        try {
            repository.deleteById(id);
            return "Successfully deleted user with ID = " + id;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public User updateUser(Long id, UserDto inputUser) {

        Optional<User> obj = repository.findById(id);
        if (obj.isPresent()) {
            User user = obj.get();
            if ((inputUser.getName() != null)) {
                user.setName(inputUser.getName());
            }
            if ((inputUser.getUserName() != null)) {
                user.setUserName(inputUser.getUserName());
            }
            if ((inputUser.getEmail() != null)) {
                user.setEmail(inputUser.getEmail());
            }
            if ((inputUser.getAddress() != null)) {
                user.setAddress(inputUser.getAddress());
            }
            if ((inputUser.getPhone() != null)) {
                user.setPhone(inputUser.getPhone());
            }

            return repository.save(user);

        } else {
            throw new NullPointerException();
        }

    }

}
