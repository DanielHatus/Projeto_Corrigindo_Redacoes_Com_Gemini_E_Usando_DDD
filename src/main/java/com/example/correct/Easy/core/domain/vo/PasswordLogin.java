package com.example.correct.Easy.core.domain.vo;

import com.example.correct.Easy.core.exceptions.DomainException;

public class PasswordLogin{
    private String passwordLogin;

    public PasswordLogin(String passwordLogin,boolean passwordLoginIsRegister){
     if (!passwordLoginIsRegister){
         validatePasswordLogin(passwordLogin);
     }
     this.passwordLogin=passwordLogin;
    }

    public String getPasswordLogin() {
        return this.passwordLogin;
    }

    private String validatePasswordLogin(String passwordLogin){
        if (passwordLogin.isBlank()){throw new DomainException("a senha de login não pode ser nula ou vazia.");}

        if (passwordLogin.length()<8 || passwordLogin.length()>16){
            throw new DomainException("a senha de login deve conter de 8 até 16 caracateres");}

        return passwordLogin;
    }
}
