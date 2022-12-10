package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.MatchResult;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.MatchUpdateResultInput;

public class MatchUpdateResultUseCase {

    MatchRepositoryInterface matchRepository;

    public MatchUpdateResultUseCase(MatchRepositoryInterface matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void execute(MatchUpdateResultInput input) {
        String[] matchResult = input.result().split("-");
        String teamAResult = matchResult[0];
        String teamBResult = matchResult[1];
        Match match = getMatch(input);
        match.setResult(new MatchResult(Integer.parseInt(teamAResult),Integer.parseInt(teamBResult)));
        matchRepository.update(match);
    }

    public Match getMatch(MatchUpdateResultInput input) {
        return matchRepository.findById(input.id());
    }
}
