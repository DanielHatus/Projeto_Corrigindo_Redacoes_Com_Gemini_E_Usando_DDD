package com.example.correct.Easy.infra.persistence.repository;

import com.example.correct.Easy.infra.persistence.model.VersionTokenPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionTokenRepository extends JpaRepository<VersionTokenPersistence,Long> {
}
