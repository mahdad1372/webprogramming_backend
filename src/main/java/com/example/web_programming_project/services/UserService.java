package com.example.web_programming_project.services;


import com.example.web_programming_project.entities.User;
import com.example.web_programming_project.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
    public List<User> fetchAll(){
        return userRepository.getAllUsers();
    }
    public void adduser(String fullName, String email, String password , String role) {
        String encoder_password = passwordEncoder.encode(password);
       userRepository.addUser(fullName,email,encoder_password,role);
    }
    public void deleteuserbyId(Integer id){
        userRepository.deleteUsersById(id);
    }
}
