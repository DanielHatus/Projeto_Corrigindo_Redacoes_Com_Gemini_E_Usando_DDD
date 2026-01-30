package com.example.correct.Easy.infra.security.implementations;

import com.example.correct.Easy.infra.exception.typo.primaries.NotFoundInfraException;
import com.example.correct.Easy.infra.persistence.repository.UserRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService{

    private UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
          UserDetailsImpl userDetails=new UserDetailsImpl(repository.findByEmail(username).get());
          return userDetails;
        }
        catch (AuthenticationException e){
            throw new NotFoundInfraException("não foi possível encontrar o usuário pelo email passado pois: "+e.getMessage());
        }
    }
}
