package com.example.correct.Easy.infra.persistence.repository;

import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserPersistence,Long>{
    Optional<UserPersistence> findByEmail(String email);
    boolean existsByEmail(String email);
}
