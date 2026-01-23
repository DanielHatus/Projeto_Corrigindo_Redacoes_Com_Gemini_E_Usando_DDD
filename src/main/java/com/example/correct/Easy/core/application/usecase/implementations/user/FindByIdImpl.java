package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.user.contracts.FindByIdContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.UserRepositoryPort;

public class FindByIdImpl implements FindByIdContract{

   private final UserRepositoryPort userPort;

    public FindByIdImpl(UserRepositoryPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public UserDomain execute(Long id){
        return userPort.findById(id)
                .orElseThrow(()->new DomainException("usuário com o id "+id+" não encontrado."));
    }
}
