package com.example.correct.Easy.core.application.usecase.contracts.tokens;

public interface GenerateAccessTokenContract{
    String execute(String email,Long idUser,Integer versionToken);
}
