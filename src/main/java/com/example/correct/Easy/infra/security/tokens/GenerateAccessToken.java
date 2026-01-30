package com.example.correct.Easy.infra.security.tokens;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateAccessToken{

    private final GenerateKeySecret keySecret;

    public GenerateAccessToken(GenerateKeySecret keySecret) {
        this.keySecret = keySecret;
    }

    @Value("${spring.jwt.access-token-expiration}")
    private long expirationTokenTime;

    public String execute(String email,Long id,Integer tokenVersion){

        Date now=new Date();
        Date timeExpiration=new Date(now.getTime()+expirationTokenTime);

        return Jwts.builder()
                .claim("email",email)
                .claim("id",id)
                .claim("versionToken",tokenVersion)
                .setIssuedAt(now)
                .setExpiration(timeExpiration)
                .signWith(keySecret.execute(), SignatureAlgorithm.HS256)
                .compact();
    }
}
