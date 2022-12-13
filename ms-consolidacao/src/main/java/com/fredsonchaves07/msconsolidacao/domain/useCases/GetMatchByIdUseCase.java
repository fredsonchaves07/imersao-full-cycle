package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchActionsOutput;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;

import java.util.List;
import java.util.UUID;

public class GetMatchByIdUseCase {

    private MatchRepositoryInterface repository;

    public GetMatchByIdUseCase(MatchRepositoryInterface repository) {
        this.repository = repository;
    }

    public MatchOutput execute(UUID id) {
        Match match = repository.findById(id);
        List<MatchActionsOutput> matchActionsOutputs = match.getActions()
                .stream()
                .map(action -> new MatchActionsOutput(
                        action.playerId().toString(), action.playerName(), action.minute(), action.action(), action.score()
                ))
                .toList();
        return new MatchOutput(
                match.getId().toString(),
                match.getTeamAId().toString(),
                match.getTeamAName(),
                match.getTeamBId().toString(),
                match.getTeamBName(),
                match.getMatchDate(),
                match.getStatus(),
                match.getResult().toString(),
                matchActionsOutputs);
    }
}
