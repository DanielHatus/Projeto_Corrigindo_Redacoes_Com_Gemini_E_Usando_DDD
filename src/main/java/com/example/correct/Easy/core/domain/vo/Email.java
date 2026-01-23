package com.example.correct.Easy.core.domain.vo;

import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.ValidateStatePort;

public class Email{
    private String email;

    public Email(String email, boolean isFromPersistence, ValidateStatePort validationState){
        if (!isFromPersistence){
            if (!validationState.emailIsValid(email)){throw new DomainException("o email "+email+" é inválido.");}
        }
        this.email=email;
    }

    public String getEmail() {
        return this.email;
    }
}
