package com.example.andreuapp.exception;

import java.time.LocalDateTime;

public class ErrorDto {

    public String message;
    private int status;
    private LocalDateTime timestamp;

    public ErrorDto(String message, int status) {}

}
