package com.example.correct.Easy.core.application.usecase.implementations.user;

import com.example.correct.Easy.core.application.usecase.contracts.user.RegisterUserContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.UserRegisterRequestDto;
import com.example.correct.Easy.core.mapper.CoreMapper;
import com.example.correct.Easy.core.ports.UserRepositoryPort;

public class RegisterUserImpl implements RegisterUserContract {

    private final UserRepositoryPort userPort;
    private final CoreMapper coreMapper;

    public RegisterUserImpl(UserRepositoryPort userPort, CoreMapper coreMapper) {
        this.userPort = userPort;
        this.coreMapper = coreMapper;
    }

    @Override
    public UserDomain execute(UserRegisterRequestDto dto) {
        UserDomain entity=coreMapper.toUserDomain(dto);
        return userPort.saveEntity(entity);
    }
}
