package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.FindByIdContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class FindByIdImpl implements FindByIdContract {

   private final UserDbPort userDbPort;
   private final UserCachePort userCachePort;

    public FindByIdImpl(UserDbPort userDbPort, UserCachePort userCachePort) {
        this.userDbPort = userDbPort;
        this.userCachePort = userCachePort;
    }

    @Override
    public UserDomain execute(Long id){

        UserDomain hitEntityInCache=this.userCachePort.getUserByIdInCache(id);
        if (hitEntityInCache!=null){
           return hitEntityInCache;
        }
        return this.userDbPort.findById(id)
                .orElseThrow(()->new DomainException("usuário com o id "+id+" não encontrado."));

    }
}
