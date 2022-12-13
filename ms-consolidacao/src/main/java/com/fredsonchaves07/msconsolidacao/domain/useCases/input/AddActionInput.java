package com.fredsonchaves07.msconsolidacao.domain.useCases.input;

import com.fredsonchaves07.msconsolidacao.domain.entities.Player;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AddActionInput(UUID actionId,  UUID matchId, UUID teamId, UUID playerId, String playerName, int minute, String action) { }
