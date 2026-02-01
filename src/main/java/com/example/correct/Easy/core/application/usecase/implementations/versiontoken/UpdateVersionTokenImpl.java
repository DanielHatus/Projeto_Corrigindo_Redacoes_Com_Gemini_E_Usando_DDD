package com.example.correct.Easy.core.application.usecase.implementations.versiontoken;

import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.UpdateVersionTokenContract;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.versiontoken.cache.VersionTokenCachePort;
import com.example.correct.Easy.core.ports.versiontoken.db.VersionTokenDbPort;

public class UpdateVersionTokenImpl implements UpdateVersionTokenContract{

    private final VersionTokenDbPort versionTokenDbPort;
    private final VersionTokenCachePort versionTokenCachePort;

    public UpdateVersionTokenImpl(VersionTokenDbPort versionTokenDbPort, VersionTokenCachePort versionTokenCachePort) {
        this.versionTokenDbPort = versionTokenDbPort;
        this.versionTokenCachePort = versionTokenCachePort;
    }

    @Override
    public VersionTokenDomain execute(VersionTokenDomain entityOld) {
        VersionTokenDomain versionTokenUpdated=this.versionTokenDbPort.updateVersionToken(entityOld);
        versionTokenCachePort.saveVersionToken(versionTokenUpdated);
        return versionTokenUpdated;
    }
}
