package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.DeleteUserByIdContract;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class DeleteUserByIdImpl implements DeleteUserByIdContract {


    private final UserDbPort userPort;
    private final UserCachePort userCachePort;

    public DeleteUserByIdImpl(UserDbPort userPort, UserCachePort userCachePort) {
        this.userPort = userPort;
        this.userCachePort = userCachePort;
    }

    @Override
    public void execute(Long id) {
        try{
           userPort.deleteById(id);
           userCachePort.deleteUserByIdInCache(id);
        }
        catch (Exception e){
            throw new DomainException("não foi possível deletar o usuário devido a: "+e.getMessage());
        }
    }
}
