package com.example.correct.Easy.core.application.usecase.contracts.user;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.UserRegisterRequestDto;

public interface RegisterUserContract {
    UserDomain execute(UserRegisterRequestDto dto);
}
