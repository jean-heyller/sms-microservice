package com.example.messaging_microservice.domain.model;

public class SmsSender {
    private String to;
    private String message;

    public SmsSender(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }
}