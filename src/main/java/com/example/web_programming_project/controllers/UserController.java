package com.example.web_programming_project.controllers;


import com.example.web_programming_project.entities.User;
import com.example.web_programming_project.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers() {
        // Ensure the user is authenticated
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Fetch and return all users
        List<User> users = userService.fetchAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/public-info")
    public String getPublicInfo() {
        return "This is a public API. No authentication required!";
    }

    // Public API 2: Another endpoint accessible without JWT
    @GetMapping("/about")
    public String getAboutInfo() {
        return "Welcome to the application! This is publicly available information.";
    }

}