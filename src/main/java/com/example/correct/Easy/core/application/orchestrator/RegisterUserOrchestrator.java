package com.example.correct.Easy.core.application.orchestrator;


import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateAccessTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateRefreshTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.RegisterVersionTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.user.RegisterUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.dto.request.RegisterUserRequestDto;
import com.example.correct.Easy.core.dto.response.TokensJwtResponseDto;

public class RegisterUserOrchestrator{
    private final RegisterUserContract registerUser;
    private final GenerateAccessTokenContract generateAccessToken;
    private final GenerateRefreshTokenContract generateRefreshToken;
    private final RegisterVersionTokenContract registerVersionToken;

    public RegisterUserOrchestrator(RegisterUserContract registerUser, GenerateAccessTokenContract generateAccessToken, GenerateRefreshTokenContract generateRefreshToken, RegisterVersionTokenContract registerVersionToken) {
        this.registerUser = registerUser;
        this.generateAccessToken = generateAccessToken;
        this.generateRefreshToken = generateRefreshToken;
        this.registerVersionToken = registerVersionToken;
    }

    public TokensJwtResponseDto execute(RegisterUserRequestDto dto){
        UserDomain entityDomain=registerUser.execute(dto);
        VersionTokenDomain versionToken=registerVersionToken.execute(entityDomain);

        return new TokensJwtResponseDto(
                generateAccessToken.execute(entityDomain.getEmail(), entityDomain.getId(), versionToken.getTokenVersion()),
                generateRefreshToken.execute(entityDomain.getEmail(), entityDomain.getId(), versionToken.getTokenVersion()));
    }
}
