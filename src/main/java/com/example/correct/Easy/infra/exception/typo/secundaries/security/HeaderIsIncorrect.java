package com.example.correct.Easy.infra.exception.typo.secundaries.security;

public class HeaderIsIncorrect extends RuntimeException {
  public HeaderIsIncorrect(String message) {
    super(message);
  }
}
