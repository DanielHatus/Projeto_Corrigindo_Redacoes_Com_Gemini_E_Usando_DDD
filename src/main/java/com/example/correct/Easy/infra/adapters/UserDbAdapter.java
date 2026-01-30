package com.example.correct.Easy.infra.adapters;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.core.ports.user.db.UserDbPort;
import com.example.correct.Easy.infra.mapper.UserMapper;
import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import com.example.correct.Easy.infra.persistence.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDbAdapter implements UserDbPort {


    private final UserPersistence userPersistence;
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserDbAdapter(UserPersistence userPersistence, UserRepository repository, UserMapper mapper) {
        this.userPersistence = userPersistence;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserDomain> findById(Long id){
        Optional<UserDomain> possibleUser=repository.findById(id).map(entity->{
            UserDomain entityConverted=mapper.toDomain(entity);
            return entityConverted;
        });
        return possibleUser;
    }

    @Override
    public UserDomain saveEntity(UserDomain entity) {
        UserPersistence entityParamConverted=mapper.toPersistence(entity);
        return mapper.toDomain(repository.save(entityParamConverted));
    }

    @Override
    public UserDomain updateEntity(UserDomain entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
     repository.deleteById(id);
    }
}
