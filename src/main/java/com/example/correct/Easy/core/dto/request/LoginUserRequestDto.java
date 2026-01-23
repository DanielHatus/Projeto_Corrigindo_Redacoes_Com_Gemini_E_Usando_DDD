package com.example.correct.Easy.core.dto.request;

public class LoginUserRequestDto{
    private String email;
    private String passwordLogin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }
}
