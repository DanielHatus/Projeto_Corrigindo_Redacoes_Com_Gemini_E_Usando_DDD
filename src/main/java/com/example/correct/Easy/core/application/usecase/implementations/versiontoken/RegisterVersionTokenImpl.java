package com.example.correct.Easy.core.application.usecase.implementations.versiontoken;

import com.example.correct.Easy.core.application.usecase.contracts.versiontoken.RegisterVersionTokenContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.versiontoken.cache.VersionTokenCachePort;
import com.example.correct.Easy.core.ports.versiontoken.db.VersionTokenDbPort;

public class RegisterVersionTokenImpl implements RegisterVersionTokenContract {
    private final VersionTokenDbPort tokenDbPort;
    private final VersionTokenCachePort tokenCachePort;

    public RegisterVersionTokenImpl(VersionTokenDbPort tokenDbPort, VersionTokenCachePort tokenCachePort) {
        this.tokenDbPort = tokenDbPort;
        this.tokenCachePort = tokenCachePort;
    }

    @Override
    public VersionTokenDomain execute(UserDomain userRef){
        VersionTokenDomain versionToken=new VersionTokenDomain(userRef);
        VersionTokenDomain versionTokenSaved=this.tokenDbPort.saveVersionToken(versionToken);
        this.tokenCachePort.saveVersionToken(versionTokenSaved);
        return versionTokenSaved;
    }
}
