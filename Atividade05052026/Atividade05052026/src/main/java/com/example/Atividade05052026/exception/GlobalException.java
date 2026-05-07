package com.example.Atividade05052026.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException (RuntimeException erro){
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("Mensage",erro.getMessage() ));
    }

    @ExceptionHandler (IllegalArgumentException.class)
    public  ResponseEntity<Map<String, Object>> illegalArgumentException (IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem",erro.getMessage()));
    }
}
