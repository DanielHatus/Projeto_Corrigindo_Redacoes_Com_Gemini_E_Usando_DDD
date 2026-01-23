package com.example.correct.Easy.core.application.usecase.contracts.user;

import com.example.correct.Easy.core.domain.model.UserDomain;

public interface UpdateUserContract{
    UserDomain execute(UserDomain entityOld);
}
