package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.ports.user.cache.UserCachePort;
import com.example.correct.Easy.infra.utils.GenerateKeyCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCacheAdapter implements UserCachePort{


    private final RedisTemplate<String,Object> redisTemplate;
    private final GenerateKeyCache keyCache;
    private final ObjectMapper mapper;

    public UserCacheAdapter(RedisTemplate<String, Object> redisTemplate, GenerateKeyCache keyCache, ObjectMapper mapper) {
        this.redisTemplate = redisTemplate;
        this.keyCache = keyCache;
        this.mapper = mapper;
    }

    @Override
    public void saveUserInCache(UserDomain entity) {
        try{
        String keyCache=this.keyCache.execute("user",entity.getId());
        redisTemplate.opsForValue().set(keyCache,entity);
      }catch (Exception e){

        }
    }

    @Override
    public UserDomain getUserByIdInCache(Long id){
        String keyGenerated=this.keyCache.execute("user",id);
        Object userSearch=redisTemplate.opsForValue().get(keyGenerated);
        return (userSearch==null?null:mapper.convertValue(userSearch,UserDomain.class));
    }

    @Override
    public void updateUserInCache(UserDomain entity) {
        String keyGenerated=this.keyCache.execute("user",entity.getId());
        this.redisTemplate.opsForValue().set(keyGenerated,entity);
    }

    @Override
    public void deleteUserByIdInCache(Long id) {
        String keyGenerated=this.keyCache.execute("user",id);
        this.redisTemplate.delete(keyGenerated);
    }
}
