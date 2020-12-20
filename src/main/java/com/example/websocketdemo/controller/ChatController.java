package com.example.websocketdemo.controller;

import com.example.websocketdemo.models.Message;
import com.example.websocketdemo.models.MessageDTO;
import com.example.websocketdemo.models.User;
import com.example.websocketdemo.services.MessageService;
import com.example.websocketdemo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {
    private final UserService userService;
    private final MessageService messageService;
    private static Logger logger= LoggerFactory.getLogger(ChatController.class);

    public ChatController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload MessageDTO messageDTO) {
        Message message=new Message();
        User user=userService.findByUsername(messageDTO.getUsername());
        message.setAuthor(user);
        message.setContent(messageDTO.getContent());
        message.setMessageType(messageDTO.getType());
        System.out.println(messageDTO);
        messageService.save(message);
        logger.info(">>>"+message.getAuthor().getUsername()+ " sent a message");
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public MessageDTO addUser(@Payload MessageDTO message,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getUsername());
        User user=new User();
        user.setUsername(message.getUsername());
        userService.save(user);
        logger.info(message.getUsername()+" joined the chat ! Great !");
        return message;
    }

}
