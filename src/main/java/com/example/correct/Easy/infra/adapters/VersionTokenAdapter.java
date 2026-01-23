package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.VersionTokenPort;
import com.example.correct.Easy.infra.mapper.VersionTokenMapper;
import com.example.correct.Easy.infra.persistence.model.VersionTokenPersistence;
import com.example.correct.Easy.infra.persistence.repository.VersionTokenRepository;

public class VersionTokenAdapter implements VersionTokenPort{

    private final VersionTokenRepository repository;
    private final VersionTokenMapper tokenMapper;

    public VersionTokenAdapter(VersionTokenRepository repository, VersionTokenMapper tokenMapper) {
        this.repository = repository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public VersionTokenDomain saveVersionToken(VersionTokenDomain versionToken) {
     VersionTokenPersistence versionTokenConverted=tokenMapper.toPersistence(versionToken);
     return tokenMapper.toDomain(versionTokenConverted);
    }
}
