package com.example.correct.Easy.core.domain.service;

import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class EmailRequestBodyIsRegistered {

    private final UserDbPort userDbPort;

    public EmailRequestBodyIsRegistered(UserDbPort userDbPort) {
        this.userDbPort = userDbPort;
    }

    public boolean execute(String email){
        return this.userDbPort.existsByEmail(email);
    }
}
