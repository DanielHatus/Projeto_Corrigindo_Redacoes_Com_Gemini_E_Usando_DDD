package com.example.correct.Easy.web.controller;

import com.example.correct.Easy.core.application.orchestrator.UpdateUserOrchestrator;
import com.example.correct.Easy.core.application.usecase.contracts.user.DeleteUserByIdContract;
import com.example.correct.Easy.core.application.usecase.contracts.user.GetUserByIdContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.UpdateUserRequestDto;
import com.example.correct.Easy.core.dto.response.TokensJwtResponseDto;
import com.example.correct.Easy.core.dto.response.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crud/user")
public class CrudUserController{

    private final GetUserByIdContract getUserById;
    private final UpdateUserOrchestrator updateOrchestrator;
    private final DeleteUserByIdContract deleteUser;


    public CrudUserController(GetUserByIdContract getUserById, UpdateUserOrchestrator updateOrchestrator, DeleteUserByIdContract deleteUser) {
        this.getUserById = getUserById;
        this.updateOrchestrator = updateOrchestrator;
        this.deleteUser = deleteUser;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id){
        UserDomain entity=this.getUserById.execute(id);
        UserResponseDto dto=new UserResponseDto(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPermission());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokensJwtResponseDto> updateUser(@RequestBody UpdateUserRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(this.updateOrchestrator.execute(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        this.deleteUser.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

