package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchActionsOutput;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;

import java.util.LinkedList;
import java.util.List;

public class ListMatchesUseCase {

    private MatchRepositoryInterface repository;

    public ListMatchesUseCase(MatchRepositoryInterface repository) {
        this.repository = repository;
    }

    public List<MatchOutput> execute() {
        List<Match> matches = repository.findAll();
        List<GameAction> actions = (List<GameAction>) matches.stream().map(match -> match.getActions());
        List<MatchActionsOutput> matchActionsOutputs = actions
                .stream()
                .map(action -> new MatchActionsOutput(
                        action.playerId().toString(), action.playerName(), action.minute(), action.action(), action.score())
                )
                .toList();
        List<MatchOutput> matchOutputs = new LinkedList<>();
        for (Match match : matches) {
            matchOutputs.add(new MatchOutput(
                    match.getId().toString(),
                    match.getTeamAId().toString(),
                    match.getTeamAName(),
                    match.getTeamBId().toString(),
                    match.getTeamBName(),
                    match.getMatchDate(),
                    match.getStatus(),
                    match.getResult().toString(),
                    matchActionsOutputs
            ));
        }
        return matchOutputs;
    }
}
