package com.leonard.springboot.error.springboot_demo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.leonard.springboot.error.springboot_demo.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionZero(Exception ex) {

        Error error = new Error(ex.getMessage(),
                "Error divicion 0",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundex(NoHandlerFoundException ex) {

        Error error = new Error(ex.getMessage(),
                "Api no encontrada",
                HttpStatus.NOT_FOUND.value(),
                new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> numberFormatException(NumberFormatException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("message", ex.getMessage());
        error.put("Error", "Fomarmato de numero no valido");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");

        return error;

    }

    @ExceptionHandler({ NullPointerException.class,
            HttpMessageNotWritableException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> userNotFoundException(Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("message", ex.getMessage());
        error.put("Error", "El Usuario no existe");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");

        return error;

    }

}
