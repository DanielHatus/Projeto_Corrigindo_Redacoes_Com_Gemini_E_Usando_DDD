package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.VersionTokenDomain;
import com.example.correct.Easy.core.ports.versiontoken.cache.VersionTokenCachePort;
import com.example.correct.Easy.infra.utils.GenerateKeyCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class VersionTokenCacheAdapter implements VersionTokenCachePort{

    private final RedisTemplate<String,Object> redisTemplate;
    private final ObjectMapper mapper;
    private final GenerateKeyCache keyCache;

    public VersionTokenCacheAdapter(RedisTemplate<String, Object> redisTemplate, ObjectMapper mapper, GenerateKeyCache keyCache) {
        this.redisTemplate = redisTemplate;
        this.mapper = mapper;
        this.keyCache = keyCache;
    }

    @Override
    public void saveVersionToken(VersionTokenDomain versionTokenDomain) {
       String generateKey=this.keyCache.execute("versionToken",versionTokenDomain.getId());
       redisTemplate.opsForValue().set(generateKey,versionTokenDomain);
    }

    @Override
    public VersionTokenDomain getVersionTokenById(Long id) {
        String generateKey=this.keyCache.execute("versionToken",id);
        Object versionTokenSearch=redisTemplate.opsForValue().get(generateKey);
        return (versionTokenSearch==null?null:this.mapper.convertValue(versionTokenSearch,VersionTokenDomain.class));
    }

}
