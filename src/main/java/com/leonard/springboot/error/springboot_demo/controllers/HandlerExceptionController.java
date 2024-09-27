package com.leonard.springboot.error.springboot_demo.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.leonard.springboot.error.springboot_demo.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionZero(Exception ex) {

        Error error = new Error(ex.getMessage(),
                "Error divicion 0",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date());
                
        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

}
