package com.example.aula19052026_api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException (RuntimeException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("Mensagem", erro.getMessage()));
    }
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException (IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", erro.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException (MethodArgumentNotValidException erro){
        String mensagem = erro.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", mensagem));
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> NoResourceFoundException (NoResourceFoundException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", "Recurso não encontrado."));
    }
}
