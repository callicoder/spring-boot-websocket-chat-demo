package com.example.websocketdemo.models;

public class MessageDTO {


    private String username;
    private String content;
    private MessageType type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
