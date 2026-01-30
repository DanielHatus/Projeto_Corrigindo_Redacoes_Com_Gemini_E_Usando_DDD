package com.example.correct.Easy.core.dto.request;

import com.example.correct.Easy.core.dto.request.vo.FullNameDto;

public class RegisterUserRequestDto {
    private FullNameDto fullName;
    private String email;
    private String passwordLogin;

    public String getFirstName() {
        return this.fullName.getFirstName();
    }

    public String getLastName(){
        return this.fullName.getLastName();
    }

    public void setFullName(FullNameDto fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordLogin() {
        return this.passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }
}
