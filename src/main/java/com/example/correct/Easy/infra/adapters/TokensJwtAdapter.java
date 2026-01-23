package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.ports.TokensJwtPort;
import com.example.correct.Easy.infra.security.tokens.GenerateAccessToken;
import com.example.correct.Easy.infra.security.tokens.GenerateRefreshToken;
import org.springframework.stereotype.Component;

@Component
public class TokensJwtAdapter implements TokensJwtPort {

    private final GenerateAccessToken generateAccessToken;
    private final GenerateRefreshToken generateRefreshToken;

    public TokensJwtAdapter(GenerateAccessToken generateAccessToken, GenerateRefreshToken generateRefreshToken) {
        this.generateAccessToken = generateAccessToken;
        this.generateRefreshToken = generateRefreshToken;
    }

    @Override
    public String generateAccessToken(String email, Long id, Integer versionToken) {
        return generateAccessToken.execute(email, id, versionToken);
    }

    @Override
    public String generateRefreshToken(String email, Long id, Integer versionToken) {
        return generateRefreshToken.execute(email, id, versionToken);
    }
}
