package com.example.andreuapp.exception;


import com.example.andreuapp.service.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorDto> MyExсeptionHandler(MyException ex) {
        return ResponseEntity.status(404)
                .body(new ErrorDto("problem", 404));
    }

}
