package com.example.websocketdemo.services;

import com.example.websocketdemo.models.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
}
