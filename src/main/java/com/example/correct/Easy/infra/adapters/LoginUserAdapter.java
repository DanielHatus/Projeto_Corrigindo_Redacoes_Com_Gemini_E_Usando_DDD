package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.ports.LoginUserPort;
import com.example.correct.Easy.infra.mapper.UserMapper;
import com.example.correct.Easy.infra.persistence.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class LoginUserAdapter implements LoginUserPort{

    private final AuthenticationManager authManager;
    private final UserRepository repository;
    private final UserMapper mapper;


    public LoginUserAdapter(AuthenticationManager authManager, UserRepository repository, UserMapper mapper) {
        this.authManager = authManager;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDomain loginUser(String email, String passwordLogin) {
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(email,passwordLogin));
        UserDomain entityDomain=mapper.toDomain(repository.findByEmail(email).get());
        return entityDomain;
    }
}
