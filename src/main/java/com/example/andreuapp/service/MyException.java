package com.example.andreuapp.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
