package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.user.contracts.DeleteUserByIdContract;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.UserRepositoryPort;

public class DeleteUserByIdImpl implements DeleteUserByIdContract{


    private final UserRepositoryPort userPort;

    public DeleteUserByIdImpl(UserRepositoryPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public void execute(Long id) {
        try{
           userPort.deleteById(id);
        }
        catch (Exception e){
            throw new DomainException("não foi possível deletar o usuário devido a: "+e.getMessage());
        }
    }
}
