package com.juanba.talkie_toki_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.core.AuthenticationException;

@RestControllerAdvice
public class FailedAuthenticationException {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity failedAuthenticationError() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseFailedAuthentication("Authentication error", "Something went wrong while trying to authenticate"));
    }

    public record ResponseFailedAuthentication(
            String typeError,
            String message
    ) {
        public ResponseFailedAuthentication(String typeError, String message) {
            this.typeError = typeError;
            this.message = message;
        }
    }
}
