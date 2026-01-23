package com.example.correct.Easy.core.application.usecase.contracts.tokens;

public interface GenerateRefreshTokenContract{
    String execute(String email,Long id,Integer versionToken);
}
