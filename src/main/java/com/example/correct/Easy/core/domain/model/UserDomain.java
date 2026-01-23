package com.example.correct.Easy.core.domain.model;

import com.example.correct.Easy.core.domain.vo.Email;
import com.example.correct.Easy.core.domain.vo.FullName;
import com.example.correct.Easy.core.domain.vo.PasswordLogin;

public class UserDomain{
    private Long id;
    private FullName fullName;
    private Email email;
    private PasswordLogin passwordLogin;


    public UserDomain(FullName fullName,Email email,PasswordLogin passwordLogin){
        this.fullName=fullName;
        this.email=email;
        this.passwordLogin=passwordLogin;
    }

    public String getEmail() {return this.email.getEmail();}

    public String getFullName(){return this.fullName.getFullName();}

    public String getPasswordLogin(){return this.passwordLogin.getPasswordLogin();}

    public Long getId(){return this.getId();}

}
