package com.example.correct.Easy.infra.security.tokens;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateRefreshToken{
    private final GenerateKeySecret keySecret;

    @Value("${spring.jwt.refresh-token-expiration}")
    private String expiration;

    public GenerateRefreshToken(GenerateKeySecret keySecret) {
        this.keySecret = keySecret;
    }

    public String execute(String email,Long id,Integer versionToken){
        Date now=new Date();
        Date timeExpiration=new Date(now.getTime()+expiration);

        return Jwts.builder()
                .claim("email",email)
                .claim("id",id)
                .claim("versionToken",versionToken)
                .setIssuedAt(now)
                .setExpiration(timeExpiration)
                .signWith(keySecret.execute(),SignatureAlgorithm.HS256)
                .compact();
    }
}
