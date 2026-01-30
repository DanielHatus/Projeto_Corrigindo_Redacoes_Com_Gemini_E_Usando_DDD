package com.example.correct.Easy.web.controller;

import com.example.correct.Easy.core.application.orchestrator.LoginUserOrchestrator;
import com.example.correct.Easy.core.application.orchestrator.RegisterUserOrchestrator;
import com.example.correct.Easy.core.dto.request.LoginUserRequestDto;
import com.example.correct.Easy.core.dto.request.RegisterUserRequestDto;
import com.example.correct.Easy.core.dto.response.TokensJwtResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController{

    private final RegisterUserOrchestrator registerOrchestrator;
    private final LoginUserOrchestrator loginOrchestrator;

    public AuthController(RegisterUserOrchestrator registerOrchestrator, LoginUserOrchestrator loginOrchestrator) {
        this.registerOrchestrator = registerOrchestrator;
        this.loginOrchestrator = loginOrchestrator;
    }

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokensJwtResponseDto> registerUser(@RequestBody RegisterUserRequestDto dto){
       return ResponseEntity.status(HttpStatus.CREATED).body(registerOrchestrator.execute(dto));
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokensJwtResponseDto> loginUser(@RequestBody LoginUserRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(loginOrchestrator.execute(dto));
    }
}
