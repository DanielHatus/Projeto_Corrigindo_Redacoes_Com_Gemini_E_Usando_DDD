package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.GetUserByIdContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.exceptions.DomainException;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class GetUserByIdImpl implements GetUserByIdContract {

   private final UserDbPort userDbPort;
   private final UserCachePort userCachePort;

    public GetUserByIdImpl(UserDbPort userDbPort, UserCachePort userCachePort) {
        this.userDbPort = userDbPort;
        this.userCachePort = userCachePort;
    }

    @Override
    public UserDomain execute(Long id){
        UserDomain searchEntityInCache=this.userCachePort.getUserByIdInCache(id);
        if (searchEntityInCache==null){
            UserDomain entity=this.userDbPort.findById(id)
                    .orElseThrow(()->new DomainException("usuário com o id "+id+" não encontrado."));
            this.userCachePort.saveUserInCache(entity);
            return entity;
        }
        return searchEntityInCache;
    }
}
