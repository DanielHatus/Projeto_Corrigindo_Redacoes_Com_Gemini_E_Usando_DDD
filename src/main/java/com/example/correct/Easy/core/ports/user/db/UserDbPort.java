package com.example.correct.Easy.core.ports.user.db;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.dto.request.UpdateUserRequestDto;

import java.util.Optional;

public interface UserDbPort {
    Optional<UserDomain> findById(Long id);
    UserDomain saveEntity(UserDomain entity);
    UserDomain updateEntity(UserDomain entityUpdatedData);
    void deleteById(Long id);
    boolean existsByEmail(String email);
}
