package com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.MatchJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchJpaEntity, String> {
}
