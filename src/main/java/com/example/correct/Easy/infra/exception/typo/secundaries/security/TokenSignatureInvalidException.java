package com.example.correct.Easy.infra.exception.typo.secundaries.security;

import org.springframework.security.core.AuthenticationException;

public class TokenSignatureInvalidException extends AuthenticationException {
    public TokenSignatureInvalidException(String message) {
        super(message);
    }
}
