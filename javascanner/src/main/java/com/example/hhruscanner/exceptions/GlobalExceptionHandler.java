package com.example.hhruscanner.exceptions;

import feign.FeignException;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionResponse> handleFeignException(FeignException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.status(), e.getMessage()), HttpStatusCode.valueOf(e.status()));
    }
}
