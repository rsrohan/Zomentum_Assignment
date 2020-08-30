package com.rsrohanverma.zomentum.classes;

public class ChatMessage {

    private User user;
    private String message;
    private String message_id;
    private String timestamp;

    public ChatMessage(String message, String message_id, String timestamp) {
        this.user = user;
        this.message = message;
        this.message_id = message_id;
        this.timestamp = timestamp;
    }

    public ChatMessage() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
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
                "user=" + user +
                ", message='" + message + '\'' +
                ", message_id='" + message_id + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
