package com.exampleremedio.remedio.tratadorerros;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratadorerro404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex){
        var erros=ex.getFieldErrors()
                .stream()
                .map(DadosErros::new)
                .toList();
        return ResponseEntity.badRequest().body(erros);

    }
    public record DadosErros(String field, String message){
        public DadosErros(FieldError erro){
            this(erro.getField(),
                    erro.getDefaultMessage());
        }
    }

}
