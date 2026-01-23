package com.example.correct.Easy.core.ports;

import com.example.correct.Easy.core.domain.model.UserDomain;

import java.util.Optional;

public interface UserRepositoryPort{
    Optional<UserDomain> findById(Long id);
    UserDomain saveEntity(UserDomain entity);
    UserDomain updateEntity(UserDomain entity);
    void deleteById(Long id);
}
