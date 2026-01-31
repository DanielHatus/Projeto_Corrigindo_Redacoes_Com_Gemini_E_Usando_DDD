package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.UpdateUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.UpdateUserRequestDto;
import com.example.correct.Easy.core.mapper.CoreMapper;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;

public class UpdateUserImpl implements UpdateUserContract{

    private final UserDbPort userDbPort;
    private final UserCachePort userCachePort;
    private final CoreMapper coreMapper;

    public UpdateUserImpl(UserDbPort userDbPort, UserCachePort userCachePort, CoreMapper coreMapper) {
        this.userDbPort = userDbPort;
        this.userCachePort = userCachePort;
        this.coreMapper = coreMapper;
    }

    public UserDomain execute(UpdateUserRequestDto dto, UserDomain entityOld){
        UserDomain buildEntityUpdated=coreMapper.toDomain(dto,entityOld);
        UserDomain entityUpdated=userDbPort.saveEntity(buildEntityUpdated);
        userCachePort.updateUserInCache(entityUpdated);
        return entityUpdated;
    }
}
