package com.example.correct.Easy.infra.exception.typo.secundaries.security;

import org.springframework.security.core.AuthenticationException;

public class VersionTokenNotEqualsException extends AuthenticationException {
    public VersionTokenNotEqualsException(String message) {
        super(message);
    }
}
