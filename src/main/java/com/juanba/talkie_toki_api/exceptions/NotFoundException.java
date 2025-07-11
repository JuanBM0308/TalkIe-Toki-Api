package com.juanba.talkie_toki_api.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageNotFoundError() {
        return ResponseEntity.notFound().build();
    }
}
