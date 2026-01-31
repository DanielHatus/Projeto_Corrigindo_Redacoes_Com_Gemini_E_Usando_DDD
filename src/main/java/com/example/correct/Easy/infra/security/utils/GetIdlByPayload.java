package com.example.correct.Easy.infra.security.utils;

import com.example.correct.Easy.infra.security.tokens.GenerateKeySecret;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class GetIdlByPayload {

    private final GenerateKeySecret keySecret;

    public GetIdlByPayload(GenerateKeySecret keySecret) {
        this.keySecret = keySecret;
    }

    public Long execute(String token){
        return Jwts.parser()
                .setSigningKey(keySecret.execute())
                .build()
                .parseClaimsJws(token)
                .getPayload()
                .get("id",Long.class);
    }
}
