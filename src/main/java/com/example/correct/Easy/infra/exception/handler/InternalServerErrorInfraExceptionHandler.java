package com.example.correct.Easy.infra.exception.handler;

import com.example.correct.Easy.infra.exception.response.runtime.ResponseGeneric;
import com.example.correct.Easy.infra.exception.typo.primaries.InternalServerErroInfraException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalTime;

@RestControllerAdvice
public class InternalServerErrorInfraExceptionHandler{

    @ExceptionHandler(InternalServerErroInfraException.class)
    public ResponseEntity<ResponseGeneric> responseHandler(InternalServerErroInfraException e){
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
        ResponseGeneric responseGeneric=new ResponseGeneric(e.getMessage(), LocalDate.now(), LocalTime.now());
        return new ResponseEntity<>(responseGeneric,status);
    }
}
