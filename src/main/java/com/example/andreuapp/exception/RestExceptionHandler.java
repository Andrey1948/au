package com.example.andreuapp.exception;


import com.example.andreuapp.service.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {


    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorDto> MyExсeptionHandler(MyException ex) {
        log.warn("Unhandled exception caught: ", ex);
        return ResponseEntity.status(404)
                .body(new ErrorDto("problem", 404, LocalDateTime.now()));
    }

}
