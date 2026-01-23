package com.example.correct.Easy.infra.persistence.model;

import com.example.correct.Easy.core.enums.Permission;
import jakarta.persistence.*;

@Entity
public class UserPersistence{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String passwordLogin;

    @Enumerated(EnumType.STRING)
    private Permission permission;

    public Long getId() {
        return id;
    }

    public UserPersistence setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserPersistence setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserPersistence setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public UserPersistence setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
        return this;
    }

    public UserPersistence setPermission(Permission permission) {
        this.permission = permission;
        return this;
    }

    public Permission getPermission() {
        return permission;
    }
}
