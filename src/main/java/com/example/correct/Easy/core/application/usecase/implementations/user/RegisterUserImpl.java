package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.RegisterUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.RegisterUserRequestDto;
import com.example.correct.Easy.core.mapper.CoreMapper;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class RegisterUserImpl implements RegisterUserContract {

    private final UserDbPort userDbPort;
    private final CoreMapper coreMapper;
    private  final UserCachePort userCachePort;

    public RegisterUserImpl(UserDbPort userDbPort, CoreMapper coreMapper, UserCachePort userCachePort) {
        this.userDbPort = userDbPort;
        this.coreMapper = coreMapper;
        this.userCachePort = userCachePort;
    }

    @Override
    public UserDomain execute(RegisterUserRequestDto dto) {
       UserDomain entity=this.coreMapper.toUserDomain(dto);
       UserDomain entitySaved=userDbPort.saveEntity(entity);
       this.userCachePort.saveUserInCache(entitySaved);
       return entitySaved;
    }
}
