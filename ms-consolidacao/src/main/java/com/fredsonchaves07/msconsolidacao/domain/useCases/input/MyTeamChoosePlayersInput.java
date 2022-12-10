package com.fredsonchaves07.msconsolidacao.domain.useCases.input;

import com.fredsonchaves07.msconsolidacao.domain.entities.Player;

import java.util.List;
import java.util.UUID;

public record MyTeamChoosePlayersInput(UUID id, List<Player> players) { }
