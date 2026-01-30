package com.example.correct.Easy.core.application.usecase.implementations.utils;

import com.example.correct.Easy.core.application.usecase.contracts.utils.LoginUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.vo.PasswordLogin;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.LoginUserPort;

public class LoginUserImpl implements LoginUserContract{

    private final LoginUserPort loginPort;

    public LoginUserImpl(LoginUserPort loginPort) {
        this.loginPort = loginPort;
    }

    @Override
    public UserDomain execute(String email, String passwordLogin) {
        try{
            return loginPort.loginUser(email, passwordLogin);
        }
        catch (Exception e){
          throw new DomainException("não foi possível logar o usuário devido ao seguinte problema: "+e.getMessage());
        }
    }
}
