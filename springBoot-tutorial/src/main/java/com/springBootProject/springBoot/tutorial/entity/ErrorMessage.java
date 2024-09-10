package com.springBootProject.springBoot.tutorial.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus status;
    private String message;

    public ErrorMessage(String message, HttpStatus status) {
        message = message;
        this.status = status;
    }

    public ErrorMessage() {}

    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
