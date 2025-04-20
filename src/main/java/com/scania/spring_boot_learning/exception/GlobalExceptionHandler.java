package com.scania.spring_boot_learning.exception;


import com.scania.spring_boot_learning.pojo.ResponseMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseMessage<String> handleConstraintViolation(ConstraintViolationException ex) {
        StringBuilder sb = new StringBuilder("Validation failed: ");

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            sb.append(violation.getPropertyPath())
                    .append(" ")
                    .append(violation.getMessage())
                    .append("; ");
        }

        return ResponseMessage.error("Validation Error", sb.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMessage<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseMessage.error("Validation failed", errors.toString());
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseMessage<String> handleAllExceptions(Exception ex) {
        System.out.println("handle all other exception name: " + ex.getClass().getName());
        return ResponseMessage.error(ex.getMessage(), "Internal Server Error");
    }
}
