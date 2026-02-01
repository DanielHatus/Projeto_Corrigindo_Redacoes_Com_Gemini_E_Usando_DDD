package com.example.correct.Easy.infra.persistence.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class VersionTokenPersistence{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserPersistence userRef;

    private Integer versionToken;

    public Long getId() {
        return id;
    }

    public VersionTokenPersistence setId(Long id) {
        this.id = id;
        return this;
    }

    public UserPersistence getUserRef() {
        return userRef;
    }

    public VersionTokenPersistence setUserRef(UserPersistence userRef) {
        this.userRef = userRef;
        return this;
    }

    public Integer getVersionToken() {
        return versionToken;
    }

    public VersionTokenPersistence setVersionToken(Integer versionToken) {
        this.versionToken = versionToken;
        return this;
    }
}
