package com.example.correct.Easy.infra.security.utils;

import com.example.correct.Easy.infra.security.tokens.GenerateKeySecret;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class GetEmailByPayload{

    private final GenerateKeySecret keySecret;

    public GetEmailByPayload(GenerateKeySecret keySecret) {
        this.keySecret = keySecret;
    }

    public String execute(String token){
        return Jwts.parser()
                .setSigningKey(keySecret.execute())
                .build()
                .parseClaimsJws(token)
                .getPayload()
                .get("email",String.class);
    }
}
