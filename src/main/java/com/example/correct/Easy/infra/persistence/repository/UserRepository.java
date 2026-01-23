package com.example.correct.Easy.infra.persistence.repository;

import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPersistence,Long>{
}
