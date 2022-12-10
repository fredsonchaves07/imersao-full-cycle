package com.fredsonchaves07.msconsolidacao.domain.repositories;

import com.fredsonchaves07.msconsolidacao.domain.entities.Team;

import java.util.UUID;

public interface TeamRepositoryInterface {

    Team findById(UUID id);
}
