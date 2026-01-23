package com.example.correct.Easy.infra.mapper;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.vo.Email;
import com.example.correct.Easy.core.domain.vo.FullName;
import com.example.correct.Easy.core.domain.vo.PasswordLogin;
import com.example.correct.Easy.core.ports.BcryptPort;
import com.example.correct.Easy.core.ports.ValidateStatePort;
import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import org.springframework.stereotype.Component;

@Component
public class UserMapper{


    private final ValidateStatePort validateStatePort;
    private final BcryptPort bcryptPort;

    public UserMapper(ValidateStatePort validateStatePort, BcryptPort bcryptPort) {
        this.validateStatePort = validateStatePort;
        this.bcryptPort = bcryptPort;
    }

    public UserDomain toDomain(UserPersistence userPersistence){
        return new UserDomain(userPersistence.getId(),
                new FullName(userPersistence.getFullName()),
                new Email(userPersistence.getEmail(), true,validateStatePort),
                new PasswordLogin(userPersistence.getPasswordLogin(), true,bcryptPort),
                userPersistence.getPermission());
    }

    public UserPersistence toPersistence(UserDomain userDomain){
        return new UserPersistence()
                .setId(userDomain.getId())
                .setFullName(userDomain.getFullName())
                .setEmail(userDomain.getEmail())
                .setPasswordLogin(userDomain.getPasswordLogin());
    }
}
