package com.example.correct.Easy.infra.persistence.repository;

import com.example.correct.Easy.infra.persistence.model.VersionTokenPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionTokenRepository extends JpaRepository<VersionTokenPersistence,Long> {
}
