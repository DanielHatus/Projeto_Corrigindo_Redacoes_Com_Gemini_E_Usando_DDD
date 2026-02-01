package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.versiontoken.db.VersionTokenDbPort;
import com.example.correct.Easy.infra.mapper.VersionTokenMapper;
import com.example.correct.Easy.infra.persistence.model.VersionTokenPersistence;
import com.example.correct.Easy.infra.persistence.repository.VersionTokenRepository;

import java.util.Optional;

public class VersionTokenDbAdapter implements VersionTokenDbPort {

    private final VersionTokenRepository repository;
    private final VersionTokenMapper tokenMapper;

    public VersionTokenDbAdapter(VersionTokenRepository repository, VersionTokenMapper tokenMapper) {
        this.repository = repository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public VersionTokenDomain saveVersionToken(VersionTokenDomain versionToken) {
     VersionTokenPersistence versionTokenConverted=tokenMapper.toPersistence(versionToken);
     return tokenMapper.toDomain(versionTokenConverted);
    }

    @Override
    public Optional<VersionTokenDomain> getVersionById(Long id) {
        Optional<VersionTokenPersistence> versionTokenPersistence=repository.findById(id);
        Optional<VersionTokenDomain> versionTokenDomain=versionTokenPersistence.map(entity->{
            VersionTokenDomain entityConverted=tokenMapper.toDomain(entity);
            return entityConverted;
        });
        return versionTokenDomain;
    }

    @Override
    public VersionTokenDomain updateVersionToken(VersionTokenDomain entityOld) {
        VersionTokenDomain newVersionToken=new VersionTokenDomain(entityOld.getId(),entityOld.getUserRef(),entityOld.getTokenVersion());
        newVersionToken.updateVersionToken();
        VersionTokenPersistence versionTokenConvertedInPersistence=this.tokenMapper.toPersistence(newVersionToken);
        return this.tokenMapper.toDomain(repository.save(versionTokenConvertedInPersistence));
    }
}
