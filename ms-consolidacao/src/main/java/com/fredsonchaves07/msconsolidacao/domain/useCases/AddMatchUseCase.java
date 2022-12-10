package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.Team;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.repositories.TeamRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.AddMatchInput;

import java.util.UUID;

public class AddMatchUseCase {

    MatchRepositoryInterface matchRepository;

    TeamRepositoryInterface teamRepository;

    public AddMatchUseCase(MatchRepositoryInterface matchRepository, TeamRepositoryInterface teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public void execute(AddMatchInput input) {
        matchRepository.create(createMatch(input));
    }

    private Match createMatch(AddMatchInput input) {
        Team teamA = getTeamById(input.teamAId());
        Team teamB = getTeamById(input.teamBId());
        return new Match(input.id(), teamA.getId(), teamA.getName(), teamB.getId(), teamB.getName(), input.date());
    }

    private Team getTeamById(UUID id) {
        return teamRepository.findById(id);
    }
}
