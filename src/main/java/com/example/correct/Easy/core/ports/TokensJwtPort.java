package com.example.correct.Easy.core.ports;

public interface TokensJwtPort {
    String generateAccessToken(String email,Long id,Integer versionToken);
    String generateRefreshToken(String email,Long id,Integer versionToken);

}
