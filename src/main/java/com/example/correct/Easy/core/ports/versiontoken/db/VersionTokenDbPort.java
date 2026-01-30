package com.example.correct.Easy.core.ports.versiontoken.db;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

import java.util.Optional;

public interface VersionTokenDbPort {
   VersionTokenDomain saveVersionToken(VersionTokenDomain versionToken);
   Optional<VersionTokenDomain> getVersionById(Long id);
}
