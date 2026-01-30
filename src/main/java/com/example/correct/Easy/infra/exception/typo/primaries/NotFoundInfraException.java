package com.example.correct.Easy.infra.exception.typo.primaries;

public class NotFoundInfraException extends RuntimeException {
    public NotFoundInfraException(String message) {
        super(message);
    }
}
