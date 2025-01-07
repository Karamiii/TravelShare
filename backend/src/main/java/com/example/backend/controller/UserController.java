package com.example.backend.controller;

import com.example.backend.model.UserModel;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    int x = 0;

    @Autowired
    private UserRepository userRepository;

    // GET /api/users - Hakee kaikki käyttäjät
    @GetMapping("/api/users")
    public List<UserModel> getAllUsers() {

        return userRepository.findAll();
    }

}
