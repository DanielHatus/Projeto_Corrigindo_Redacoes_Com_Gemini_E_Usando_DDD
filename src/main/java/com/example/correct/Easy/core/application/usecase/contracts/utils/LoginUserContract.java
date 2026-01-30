package com.example.correct.Easy.core.application.usecase.contracts.utils;

import com.example.correct.Easy.core.domain.model.UserDomain;

public interface LoginUserContract{

    UserDomain execute(String email, String passwordLogin);
}
