package br.com.fiap.FarmaNear_Register.infra.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<String> handleMediaTypeException(HttpMediaTypeNotAcceptableException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Media type not acceptable");
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(InsufficientAuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication required");
    }

}
