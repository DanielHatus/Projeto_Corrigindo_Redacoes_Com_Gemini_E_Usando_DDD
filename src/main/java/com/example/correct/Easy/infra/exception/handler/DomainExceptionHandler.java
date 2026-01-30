package com.example.correct.Easy.infra.exception.handler;

import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.infra.exception.response.runtime.ResponseGeneric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalTime;

@RestControllerAdvice
public class DomainExceptionHandler{

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ResponseGeneric> responseHandler(DomainException e){
        HttpStatus status=HttpStatus.BAD_REQUEST;
        ResponseGeneric responseGeneric=new ResponseGeneric(e.getMessage(), LocalDate.now(), LocalTime.now());
        return new ResponseEntity<>(responseGeneric,status);
    }
}
