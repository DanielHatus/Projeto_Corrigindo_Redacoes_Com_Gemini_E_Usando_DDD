package com.example.correct.Easy.core.application.usecase.implementations.tokens;

import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateAccessTokenContract;
import com.example.correct.Easy.core.ports.TokensJwtPort;

public class GenerateAccessTokenImpl implements GenerateAccessTokenContract{

    private final TokensJwtPort jwtPort;

    public GenerateAccessTokenImpl(TokensJwtPort jwtPort) {
        this.jwtPort = jwtPort;
    }

    @Override
    public String execute(String email, Long idUser, Integer versionToken) {
        return jwtPort.generateAccessToken(email, idUser, versionToken);
    }
}
