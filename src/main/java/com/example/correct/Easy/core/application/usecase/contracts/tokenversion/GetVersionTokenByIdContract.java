package com.example.correct.Easy.core.application.usecase.contracts.tokenversion;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

public interface GetVersionTokenByIdContract{
    VersionTokenDomain execute(Long id);

}
