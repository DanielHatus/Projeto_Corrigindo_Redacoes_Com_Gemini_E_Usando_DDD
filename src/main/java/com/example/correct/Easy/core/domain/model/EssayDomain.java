package com.example.correct.Easy.core.domain.model;

import com.example.correct.Easy.core.exceptions.DomainException;

import java.time.LocalDate;

public class EssayDomain{
    private Long id;
    private UserDomain userRef;
    private String textEssay;
    private LocalDate createEssayDate;


    public EssayDomain(UserDomain userRef,String textEssay){
        this.userRef=validateUserRef(userRef);
        this.textEssay=validateTextEssay(textEssay);
        this.createEssayDate=LocalDate.now();
    }

    public EssayDomain(Long id, UserDomain userRef, String textEssay, LocalDate createEssayDate) {
        this.id = id;
        this.userRef = userRef;
        this.textEssay = textEssay;
        this.createEssayDate = createEssayDate;
    }

    private UserDomain validateUserRef(UserDomain userRef){
        if (userRef==null){throw new DomainException("a referencia ao usuário não pode ser nula.");}
        return userRef;
    }

    private String validateTextEssay(String textEssay){
        if (textEssay.isBlank()){throw new DomainException("a redação do usuário não pode ser nula ou vazia.");}

        if (textEssay.length()<8||textEssay.length()>3000 ){
            throw new DomainException("a redação do usuário não pode ser menor que 8 e nem maior que 3000 caracteres.");}

        return textEssay;
    }
}
