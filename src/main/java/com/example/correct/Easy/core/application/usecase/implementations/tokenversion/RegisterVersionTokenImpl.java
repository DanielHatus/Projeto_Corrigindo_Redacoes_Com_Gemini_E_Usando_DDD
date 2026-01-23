package com.example.correct.Easy.core.application.usecase.implementations.tokenversion;

import com.example.correct.Easy.core.application.usecase.contracts.tokenversion.RegisterVersionTokenContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.VersionTokenPort;

public class RegisterVersionTokenImpl implements RegisterVersionTokenContract {


    private final VersionTokenPort tokenPort;

    public RegisterVersionTokenImpl(VersionTokenPort tokenPort) {
        this.tokenPort = tokenPort;
    }

    @Override
    public VersionTokenDomain execute(UserDomain userRef){
        VersionTokenDomain versionToken=new VersionTokenDomain(userRef);
        return tokenPort.saveVersionToken(versionToken);
    }
}
