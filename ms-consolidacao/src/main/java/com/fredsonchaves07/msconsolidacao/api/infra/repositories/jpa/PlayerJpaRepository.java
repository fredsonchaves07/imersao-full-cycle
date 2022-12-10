package com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.PlayerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerJpaEntity, UUID> {
}
