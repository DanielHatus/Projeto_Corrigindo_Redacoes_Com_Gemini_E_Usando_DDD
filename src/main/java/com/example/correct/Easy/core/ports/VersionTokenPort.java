package com.example.correct.Easy.core.ports;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;

public interface VersionTokenPort{
   VersionTokenDomain saveVersionToken(VersionTokenDomain versionToken);
}
