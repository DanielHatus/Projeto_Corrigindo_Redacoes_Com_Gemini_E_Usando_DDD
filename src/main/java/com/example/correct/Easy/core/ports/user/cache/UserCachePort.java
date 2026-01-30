package com.example.correct.Easy.core.ports.user.cache;

import com.example.correct.Easy.core.domain.model.UserDomain;

public interface UserCachePort{
    void saveUserInCache(UserDomain entity);
    void updateUserInCache(UserDomain entity);
    UserDomain getUserByIdInCache(Long id);
    void deleteUserByIdInCache(Long id);
}
