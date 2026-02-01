package com.example.correct.Easy.core.application.usecase.implementations.versiontoken;

import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.GetVersionTokenByIdContract;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.versiontoken.cache.VersionTokenCachePort;
import com.example.correct.Easy.core.ports.versiontoken.db.VersionTokenDbPort;

public class GetVersionTokenByIdImpl implements GetVersionTokenByIdContract{

    private final VersionTokenDbPort versionTokenDbPort;
    private final VersionTokenCachePort versionTokenCachePort;

    public GetVersionTokenByIdImpl(VersionTokenDbPort versionTokenDbPort, VersionTokenCachePort versionTokenCachePort) {
        this.versionTokenDbPort = versionTokenDbPort;
        this.versionTokenCachePort = versionTokenCachePort;
    }


    @Override
    public VersionTokenDomain execute(Long id) {
        VersionTokenDomain searchVersionTokenInCache=this.versionTokenCachePort.getVersionTokenById(id);
        if (searchVersionTokenInCache!=null){return searchVersionTokenInCache;}

        VersionTokenDomain entityReturned=versionTokenDbPort.getVersionById(id)
              .orElseThrow(()->new DomainException("a versão do token não foi encontrada para a entidade do id: "+id));
        this.versionTokenCachePort.saveVersionToken(entityReturned);
        return entityReturned;
    }
}
