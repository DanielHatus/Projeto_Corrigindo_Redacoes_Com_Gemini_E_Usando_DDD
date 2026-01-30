package com.example.correct.Easy.infra.exception.handler;

import com.example.correct.Easy.infra.exception.response.runtime.ResponseGeneric;
import com.example.correct.Easy.infra.exception.typo.primaries.NotFoundInfraException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalTime;

@RestControllerAdvice
public class NotFoundInfraExceptionHandler {

    @ExceptionHandler(NotFoundInfraException.class)
    public ResponseEntity<ResponseGeneric> responseHandler(NotFoundInfraException e){
        HttpStatus status=HttpStatus.NOT_FOUND;
        ResponseGeneric responseGeneric=new ResponseGeneric(e.getMessage(), LocalDate.now(), LocalTime.now());
        return new ResponseEntity<>(responseGeneric,status);
    }
}
