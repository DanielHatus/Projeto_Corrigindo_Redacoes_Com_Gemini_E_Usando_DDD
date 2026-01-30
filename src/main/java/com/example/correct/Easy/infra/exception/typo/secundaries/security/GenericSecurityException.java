package com.example.correct.Easy.infra.exception.typo.secundaries.security;

import org.springframework.security.core.AuthenticationException;

public class GenericSecurityException extends AuthenticationException {
    public GenericSecurityException(String message) {
        super(message);
    }
}
