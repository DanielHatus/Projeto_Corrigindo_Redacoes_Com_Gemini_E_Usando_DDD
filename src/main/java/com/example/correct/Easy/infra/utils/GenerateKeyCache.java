package com.example.correct.Easy.infra.utils;

import org.springframework.stereotype.Component;

@Component
public class GenerateKeyCache{

    public String execute(String typeKeyName,Object identification){
        return typeKeyName+":"+identification;
    }
}
