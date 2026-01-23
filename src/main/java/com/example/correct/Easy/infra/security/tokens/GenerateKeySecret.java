package com.example.correct.Easy.infra.security.tokens;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;

@Component
public class GenerateKeySecret{


    @Value("${spring.jwt.secret-key-in-base-64}")
    private String keyBase64;

    public Key execute(){
       byte[] bytes= Base64.getDecoder().decode(keyBase64);
       return Keys.hmacShaKeyFor(bytes);
    }
}
