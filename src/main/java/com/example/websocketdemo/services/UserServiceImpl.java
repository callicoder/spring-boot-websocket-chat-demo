package com.example.websocketdemo.services;

import com.example.websocketdemo.models.User;
import com.example.websocketdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> userOptional=userRepository.findByUsername(username);
        if(! userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        User user=userOptional.get();
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
