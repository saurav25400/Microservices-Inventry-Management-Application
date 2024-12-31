package com.example.codingshuttle.order_service.advices;

import com.example.codingshuttle.order_service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String>catchReourceNotFoundException(ResourceNotFoundException ex){
//        ApiError apiError=ApiError.builder()
//                .message(ex.getLocalizedMessage())
//                .httpStatusCode(HttpStatus.NOT_FOUND)
//                .timestamp(LocalDateTime.now())
//                .build();
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }
}
