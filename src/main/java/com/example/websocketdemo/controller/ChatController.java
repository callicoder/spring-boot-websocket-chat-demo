package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 * modified by leonteqsecurity on 9th july 2023
 */
@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        // This method is invoked when a chat message is received from a client
        // and it sends the message to all subscribed clients through the "/topic/public" destination
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // This method is invoked when a new user joins the chat
        // It adds the username to the WebSocket session attributes
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        // It sends the chat message to all subscribed clients through the "/topic/public" destination
        return chatMessage;
    }

}
