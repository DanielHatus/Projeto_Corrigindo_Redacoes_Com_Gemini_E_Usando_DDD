package com.example.correct.Easy.core.mapper;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.domain.vo.Email;
import com.example.correct.Easy.core.domain.vo.FullName;
import com.example.correct.Easy.core.domain.vo.PasswordLogin;
import com.example.correct.Easy.core.dto.request.RegisterUserRequestDto;
import com.example.correct.Easy.core.ports.BcryptPort;
import com.example.correct.Easy.core.ports.ValidateStatePort;

public class CoreMapper{

    private final  ValidateStatePort validateStatePort;
    private final BcryptPort bcryptPort;

    public CoreMapper(ValidateStatePort validateStatePort, BcryptPort bcryptPort) {
        this.validateStatePort = validateStatePort;
        this.bcryptPort = bcryptPort;
    }

    public UserDomain toUserDomain(RegisterUserRequestDto dto){
        return new UserDomain(
                new FullName(dto.getFirstName(),dto.getLastName()),
                new Email(dto.getEmail(),false,validateStatePort),
                new PasswordLogin(dto.getPasswordLogin(),false,bcryptPort));
    }
}
