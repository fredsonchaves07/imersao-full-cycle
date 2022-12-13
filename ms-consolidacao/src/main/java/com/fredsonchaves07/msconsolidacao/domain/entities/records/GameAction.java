package com.fredsonchaves07.msconsolidacao.domain.entities.records;

import java.util.UUID;

public record GameAction(
        UUID id,
        UUID playerId,
        String playerName,
        UUID teamId,
        int minute,
        String action,
        int score
) {
}
