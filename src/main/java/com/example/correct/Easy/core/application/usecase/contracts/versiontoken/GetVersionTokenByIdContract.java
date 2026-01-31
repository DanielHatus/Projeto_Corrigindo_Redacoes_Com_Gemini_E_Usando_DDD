package com.example.correct.Easy.core.application.usecase.contracts.versiontoken;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

public interface GetVersionTokenByIdContract{
    VersionTokenDomain execute(Long id);

}
