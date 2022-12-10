package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MyTeamRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;

import java.util.List;
import java.util.UUID;

public class MyTeamPlayersUseCase {

    private MyTeamRepositoryInterface repository;

    public MyTeamPlayersUseCase(MyTeamRepositoryInterface repository) {
        this.repository = repository;
    }

    public List<PlayerOutput> execute(UUID id) {
        MyTeam myTeam = repository.findById(id);
        return myTeam.getPlayers()
                .stream()
                .map(player -> new PlayerOutput(player.getId().toString(), player.getName(), player.getPrice()))
                .toList();
    }
}
