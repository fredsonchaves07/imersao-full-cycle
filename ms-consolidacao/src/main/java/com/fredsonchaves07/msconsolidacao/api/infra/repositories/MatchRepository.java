package com.fredsonchaves07.msconsolidacao.api.infra.repositories;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.MatchJpaEntity;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa.MatchJpaRepository;
import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.MatchResult;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MatchRepository implements MatchRepositoryInterface {

    @Autowired
    private MatchJpaRepository repository;

    @Override
    public Match findById(UUID id) {
        MatchJpaEntity match = repository.findById(id.toString()).get();
        return new Match(
                UUID.fromString(match.getId()),
                UUID.fromString(match.getTeamAId()),
                match.getTeamAName(),
                UUID.fromString(match.getTeamBId()),
                match.getTeamBName(),
                match.getMatchDate()
        );
    }

    @Override
    public List<Match> findAll() {
        return repository.findAll()
                .stream()
                .map(match -> new Match(
                        UUID.fromString(match.getId()),
                        UUID.fromString(match.getTeamAId()),
                        match.getTeamAName(),
                        UUID.fromString(match.getTeamBId()),
                        match.getTeamBName(),
                        match.getMatchDate(),
                        new MatchResult(Integer.parseInt(match.getResult().split("-")[0]), Integer.parseInt(match.getResult().split("-")[1])))
                )
                .toList();
    }

    @Override
    public void create(Match match) {
        MatchJpaEntity matchJpa= new MatchJpaEntity(
                match.getId().toString(),
                match.getMatchDate(),
                match.getTeamAId().toString(),
                match.getTeamAName(),
                match.getTeamBId().toString(),
                match.getTeamBName(),
                match.getResult().toString()
        );
        repository.save(matchJpa);
    }

    @Override
    public void saveAction(Match match, int score) {
        //TODO -> Implementar métodos faltando
    }

    @Override
    public void update(Match match) {
        MatchJpaEntity matchJpa = repository.findById(match.getId().toString()).get();
        repository.save(matchJpa);
    }
}
