package com.example.correct.Easy.core.application.usecase.contracts.versiontoken;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

public interface RegisterVersionTokenContract {
    VersionTokenDomain execute(UserDomain userRef);
}
