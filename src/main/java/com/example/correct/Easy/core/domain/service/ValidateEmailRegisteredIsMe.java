package com.example.correct.Easy.core.domain.service;

import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.UtilsPort;

public class ValidateEmailRegisteredIsMe {


    private final UtilsPort utilsPort;

    public ValidateEmailRegisteredIsMe(UtilsPort utilsPort) {
        this.utilsPort = utilsPort;
    }

    public void execute(String emailRequestBody, boolean emailIsRegisteredInServer){
        if (emailIsRegisteredInServer){
            String emailUserToken= utilsPort.getEmailUserInContextSecurity();
           if (!emailUserToken.equals(emailRequestBody)){
               throw new DomainException("o email passado na requisição já esta cadastrado,e ele não é o seuu email cadastrado em sua conta.");
           }
        }
    }
}
