package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;

import java.util.List;

public class ListPlayersUseCase {

    public PlayerRepositoryInterface playerRepository;

    public ListPlayersUseCase(PlayerRepositoryInterface playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerOutput> execute() {
        return playerRepository
                .findAll()
                .stream()
                .map(player ->
                        new PlayerOutput(player.getId().toString(), player.getName(), player.getPrice()))
                .toList();
    }
}
