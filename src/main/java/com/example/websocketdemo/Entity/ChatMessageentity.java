package com.example.websocketdemo.Entity;

import javax.persistence.*;

@Entity
public class ChatMessageentity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "content")
    private String content;
    @Column(name = "sender")
    private String sender;
    public ChatMessageentity() {
    }
    public ChatMessageentity(String type, String content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }
    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}