package com.example.correct.Easy.core.ports.versiontoken.cache;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

public interface VersionTokenCachePort{
    void saveVersionToken(VersionTokenDomain versionTokenDomain);
    VersionTokenDomain getVersionTokenById(Long id);
    void deleteVersionToken(Long id);
}
