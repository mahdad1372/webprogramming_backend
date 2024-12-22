package com.example.web_programming_project.services;


import com.example.web_programming_project.entities.User;
import com.example.web_programming_project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
    public List<User> fetchAll(){
        return userRepository.getAllUsers();
    }
//    public List<User> allUsers2() {
//
//        return userRepository.getAllUsers();
//    }
}
