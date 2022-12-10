package com.fredsonchaves07.msconsolidacao.domain.repositories;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;

import java.util.List;
import java.util.UUID;

public interface MatchRepositoryInterface {

    Match findById(UUID id);

    List<Match> findAll();

    void create(Match match);

    void saveAction(Match match, int score);

    void update(Match match);
}
