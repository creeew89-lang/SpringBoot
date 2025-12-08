package com.codeline.apis.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalExceptionHandler{
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>>
            handleValidation(ValidationException ex){
        return ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()));
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Map<String, String>>handleDuplicate(DuplicateResourceException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body((Map.of("error", ex.getMessage())));
    }
}
