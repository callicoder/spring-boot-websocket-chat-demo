package com.example.websocketdemo.model;

import java.util.Date;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String timestamp;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        TYPING
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMessage that = (ChatMessage) o;

        return sender != null ? sender.equals(that.sender) : that.sender == null;
    }

    @Override
    public int hashCode() {
        return sender != null ? sender.hashCode() : 0;
    }
}
