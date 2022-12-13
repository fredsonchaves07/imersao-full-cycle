package com.fredsonchaves07.msconsolidacao.api.infra.repositories;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.ActionJpaEntity;
import com.fredsonchaves07.msconsolidacao.api.infra.entities.MatchJpaEntity;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa.MatchJpaRepository;
import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.MatchResult;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class MatchRepository implements MatchRepositoryInterface {

    @Autowired
    private MatchJpaRepository repository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Match findById(UUID id) {
        MatchJpaEntity match = repository.findById(id.toString()).get();
        return new Match(
                UUID.fromString(match.getId()),
                UUID.fromString(match.getTeamAId()),
                match.getTeamAName(),
                UUID.fromString(match.getTeamBId()),
                match.getTeamBName(),
                match.getMatchDate(),
                new MatchResult(Integer.parseInt(match.getResult().split("-")[0]), Integer.parseInt(match.getResult().split("-")[1])),
                match.getActions().stream().map(action -> new GameAction(
                        UUID.fromString(action.getId()),
                        UUID.fromString(action.getPlayer_id()),
                        playerRepository.findById(UUID.fromString(action.getPlayer_id())).getName(),
                        UUID.fromString(action.getTeam_id()),
                        action.getMinute(),
                        action.getAction(),
                        action.getScore()
                )).toList()
        );
    }

    @Override
    public List<Match> findAll() {
        List<Match> matches = new LinkedList<>();
        List<MatchJpaEntity> matchesJpaEntity = repository.findAll();
        for (MatchJpaEntity matchJpa : matchesJpaEntity) {
            List<GameAction> actions = new LinkedList<>();
            for (ActionJpaEntity gameAction : matchJpa.getActions()) {
                actions.add(
                        new GameAction(
                                UUID.fromString(gameAction.getId()),
                                UUID.fromString(gameAction.getPlayer_id()),
                                playerRepository.findById(UUID.fromString(gameAction.getPlayer_id())).getName(),
                                UUID.fromString(gameAction.getTeam_id()),
                                gameAction.getMinute(),
                                gameAction.getAction(),
                                gameAction.getScore()
                        )
                );
            }
            matches.add(
                    new Match(
                            UUID.fromString(matchJpa.getId()),
                            UUID.fromString(matchJpa.getTeamAId()),
                            matchJpa.getTeamAName(),
                            UUID.fromString(matchJpa.getTeamBId()),
                            matchJpa.getTeamBName(),
                            matchJpa.getMatchDate(),
                            new MatchResult(Integer.parseInt(matchJpa.getResult().split("-")[0]), Integer.parseInt(matchJpa.getResult().split("-")[1])),
                            actions
                            ));
        }

        return matches;
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
                match.getResult().toString(),
                null
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
