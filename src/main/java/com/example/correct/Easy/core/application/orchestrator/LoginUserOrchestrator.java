package com.example.correct.Easy.core.application.orchestrator;

import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateAccessTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateRefreshTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.tokenversion.GetVersionTokenByIdContract;
import com.example.correct.Easy.core.application.usecase.contracts.utils.LoginUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.dto.request.LoginUserRequestDto;
import com.example.correct.Easy.core.dto.response.TokensJwtResponseDto;

public class LoginUserOrchestrator{

    private final LoginUserContract loginUser;
    private final GenerateAccessTokenContract generateAccessToken;
    private final GenerateRefreshTokenContract generateRefreshToken;
    private final GetVersionTokenByIdContract getVersionTokenById;

    public LoginUserOrchestrator(LoginUserContract loginUser, GenerateAccessTokenContract generateAccessToken, GenerateRefreshTokenContract generateRefreshToken, GetVersionTokenByIdContract getVersionTokenById) {
        this.loginUser = loginUser;
        this.generateAccessToken = generateAccessToken;
        this.generateRefreshToken = generateRefreshToken;
        this.getVersionTokenById = getVersionTokenById;
    }

    public TokensJwtResponseDto execute(LoginUserRequestDto dto){
        UserDomain entityLogin=loginUser.execute(dto.getEmail(), dto.getPasswordLogin());
        VersionTokenDomain versionTokenDomain=getVersionTokenById.execute(entityLogin.getId());
        return new TokensJwtResponseDto(
                generateAccessToken.execute(entityLogin.getEmail(), entityLogin.getId(), versionTokenDomain.getTokenVersion()),
                generateRefreshToken.execute(entityLogin.getEmail(), entityLogin.getId(), versionTokenDomain.getTokenVersion()));
    }
}
