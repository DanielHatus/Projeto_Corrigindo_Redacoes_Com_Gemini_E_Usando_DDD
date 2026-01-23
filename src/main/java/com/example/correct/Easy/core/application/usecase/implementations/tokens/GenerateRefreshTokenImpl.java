package com.example.correct.Easy.core.application.usecase.implementations.tokens;

import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateRefreshTokenContract;
import com.example.correct.Easy.core.ports.TokensJwtPort;

public class GenerateRefreshTokenImpl implements GenerateRefreshTokenContract {

    private final TokensJwtPort jwtPort;

    public GenerateRefreshTokenImpl(TokensJwtPort jwtPort) {
        this.jwtPort = jwtPort;
    }

    @Override
    public String execute(String email, Long idUser, Integer versionToken) {
      return jwtPort.generateRefreshToken(email, idUser, versionToken);
    }
}
