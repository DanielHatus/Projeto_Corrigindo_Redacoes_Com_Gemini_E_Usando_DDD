package com.example.correct.Easy.infra.exception.typo.secundaries.security;

import org.springframework.security.core.AuthenticationException;

public class HeaderIsIncorrect extends AuthenticationException {
    public HeaderIsIncorrect(String message) {
        super(message);
    }
}
