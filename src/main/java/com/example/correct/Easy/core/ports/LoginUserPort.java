package com.example.correct.Easy.core.ports;

import com.example.correct.Easy.core.domain.model.UserDomain;

public interface LoginUserPort{
    UserDomain loginUser(String email, String passwordLogin) throws Exception;
}
