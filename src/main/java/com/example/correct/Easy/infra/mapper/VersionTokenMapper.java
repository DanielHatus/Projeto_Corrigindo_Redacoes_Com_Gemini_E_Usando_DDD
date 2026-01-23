package com.example.correct.Easy.infra.mapper;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.infra.persistence.model.VersionTokenPersistence;
import org.springframework.stereotype.Component;

@Component
public class VersionTokenMapper{

    private final UserMapper userMapper;

    public VersionTokenMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public VersionTokenPersistence toPersistence(VersionTokenDomain versionToken){
        return new VersionTokenPersistence()
                .setId(versionToken.getId())
                .setUserRef(userMapper.toPersistence(versionToken.getUserRef()))
                .setVersionToken(versionToken.getTokenVersion());
    }

    public VersionTokenDomain toDomain(VersionTokenPersistence versionToken){
        return new VersionTokenDomain(versionToken.getId(),
                userMapper.toDomain(versionToken.getUserRef()),
                versionToken.getVersionToken());
    }
}
