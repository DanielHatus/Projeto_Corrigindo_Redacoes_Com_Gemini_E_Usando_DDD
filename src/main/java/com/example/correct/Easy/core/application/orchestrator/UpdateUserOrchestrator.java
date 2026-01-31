package com.example.correct.Easy.core.application.orchestrator;

import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateAccessTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.tokens.GenerateRefreshTokenContract;
import com.example.correct.Easy.core.application.usecase.contracts.user.GetUserByIdContract;
import com.example.correct.Easy.core.application.usecase.contracts.user.UpdateUserContract;
import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.GetVersionTokenByIdContract;
import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.UpdateVersionTokenContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.domain.service.EmailRequestBodyIsRegistered;
import com.example.correct.Easy.core.domain.service.ValidateEmailRegisteredIsMe;
import com.example.correct.Easy.core.dto.request.UpdateUserRequestDto;
import com.example.correct.Easy.core.dto.response.TokensJwtResponseDto;
import com.example.correct.Easy.core.ports.UtilsPort;

public class UpdateUserOrchestrator{

    private final EmailRequestBodyIsRegistered isRegistered;
    private final ValidateEmailRegisteredIsMe validateEmail;
    private final UpdateUserContract updateUser;
    private final UtilsPort utilsPort;
    private final GetUserByIdContract getUserById;
    private final GetVersionTokenByIdContract getVersionTokenById;
    private final UpdateVersionTokenContract updateVersionToken;
    private final GenerateAccessTokenContract generateAccessToken;
    private final GenerateRefreshTokenContract generateRefreshToken;


    public UpdateUserOrchestrator(EmailRequestBodyIsRegistered isRegistered, ValidateEmailRegisteredIsMe validateEmail, UpdateUserContract updateUser, UtilsPort utilsPort, GetUserByIdContract getUserById, GetVersionTokenByIdContract getVersionTokenById, UpdateVersionTokenContract updateVersionToken, GenerateAccessTokenContract generateAccessToken, GenerateRefreshTokenContract generateRefreshToken) {
        this.isRegistered = isRegistered;
        this.validateEmail = validateEmail;
        this.updateUser = updateUser;
        this.utilsPort = utilsPort;
        this.getUserById = getUserById;
        this.getVersionTokenById = getVersionTokenById;
        this.updateVersionToken = updateVersionToken;
        this.generateAccessToken = generateAccessToken;
        this.generateRefreshToken = generateRefreshToken;
    }

    public TokensJwtResponseDto execute(UpdateUserRequestDto dto){
       validateEmail.execute(dto.getEmail(), isRegistered.execute(dto.getEmail()));
       Long idUserToken= utilsPort.getIdUserInContextSecurity();
       UserDomain entityUpdated=updateUser.execute(dto,getUserById.execute(idUserToken));
       VersionTokenDomain versionTokenUpdate=updateVersionToken.execute(this.getVersionTokenById.execute(entityUpdated.getId()));
       return new TokensJwtResponseDto(
               this.generateAccessToken.execute(entityUpdated.getEmail(), entityUpdated.getId(), versionTokenUpdate.getTokenVersion()),
               this.generateRefreshToken.execute(entityUpdated.getEmail(), entityUpdated.getId(),versionTokenUpdate.getTokenVersion()));
    }
}
