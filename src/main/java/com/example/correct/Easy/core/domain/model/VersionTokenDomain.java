package com.example.correct.Easy.core.domain.model;

import com.example.correct.Easy.core.exceptions.DomainException;

public class VersionTokenDomain{
    private Long id;
    private UserDomain userRef;
    private Integer tokenVersion;


    private UserDomain validateUserRef(UserDomain userRef){
        if (userRef==null){
            throw new DomainException("a refrencia ao usuário não pode ser nula.");
        }
        return userRef;
    }

    public VersionTokenDomain(Long id,UserDomain userRef,Integer tokenVersion){
        this.id=id;
        this.userRef=validateUserRef(userRef);
        this.tokenVersion=tokenVersion;
    }

    public VersionTokenDomain(UserDomain userRef){
        this.userRef=validateUserRef(userRef);
        this.tokenVersion=1;
    }

    public Long getId() {
        return id;
    }

    public UserDomain getUserRef() {
        return userRef;
    }

    public Integer getTokenVersion() {
        return tokenVersion;
    }

    public void updateVersionToken(){this.tokenVersion+=1;}
}
