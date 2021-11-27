package com.example.websocketdemo.services;

import com.example.websocketdemo.models.Message;

import java.util.List;

public interface MessageService {
    void save(Message message);
    List<Message> findAll();
}
