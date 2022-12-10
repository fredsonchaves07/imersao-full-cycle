package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.AddPlayerInput;

public class AddPlayerUseCase {

    PlayerRepositoryInterface playerRepository;

    public AddPlayerUseCase(PlayerRepositoryInterface playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void execute(AddPlayerInput input) {
        playerRepository.create(createPlayer(input));
    }

    private Player createPlayer(AddPlayerInput input) {
        return new Player(input.id(), input.name(), input.initialPrice());
    }
}
