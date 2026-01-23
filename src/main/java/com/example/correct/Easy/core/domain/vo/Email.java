package com.example.correct.Easy.core.domain.vo;

import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.ValidationStatePort;

public class Email{
    private String email;

    public Email(String email,boolean emailIsRegistered,ValidationStatePort validationState){
        if (!emailIsRegistered){
            if (!validationState.emailIsValid(email)){throw new DomainException("o email "+email+" é inválido.");}
        }
        this.email=email;
    }

    public String getEmail() {
        return this.email;
    }
}
