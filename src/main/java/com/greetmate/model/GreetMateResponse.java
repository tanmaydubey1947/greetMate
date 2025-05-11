package com.greetmate.model;

public class GreetMateResponse {

    String message;

    public GreetMateResponse() {

    }

    public GreetMateResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}