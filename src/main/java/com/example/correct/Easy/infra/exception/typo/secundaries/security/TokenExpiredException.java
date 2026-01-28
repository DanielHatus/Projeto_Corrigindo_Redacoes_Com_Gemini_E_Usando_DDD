package com.example.correct.Easy.infra.exception.typo.secundaries.security;

public class TokenExpiredException extends RuntimeException {
  public TokenExpiredException(String message) {
    super(message);
  }
}
