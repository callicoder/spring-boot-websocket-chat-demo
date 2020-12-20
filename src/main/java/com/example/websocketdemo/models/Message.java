package com.example.websocketdemo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.*;

import java.util.Date;
import java.util.UUID;

import static javax.persistence.FetchType.EAGER;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String content;
    private Date created=new Date();

    @JsonManagedReference
    @ManyToOne(fetch=EAGER)
    @JoinColumn(name="fk_author")
    private User author;

    @Enumerated(value=EnumType.STRING)
    private MessageType messageType;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", author=" + author +
                ", messageType=" + messageType +
                '}';
    }
}
