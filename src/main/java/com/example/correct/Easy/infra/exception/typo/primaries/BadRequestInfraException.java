package com.example.correct.Easy.infra.exception.typo.primaries;

public class BadRequestInfraException extends RuntimeException{
    public BadRequestInfraException(String msg){
        super(msg);
    }
}
