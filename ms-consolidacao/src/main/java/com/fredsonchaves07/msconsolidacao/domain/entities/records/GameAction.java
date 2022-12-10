package com.fredsonchaves07.msconsolidacao.domain.entities.records;

import java.util.UUID;

public record GameAction(UUID playerId, String playerName, int minute, String action, int score) {
}
