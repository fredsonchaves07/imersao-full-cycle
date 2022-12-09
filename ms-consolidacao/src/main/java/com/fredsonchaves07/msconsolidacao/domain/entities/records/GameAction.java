package com.fredsonchaves07.msconsolidacao.domain.entities.records;

import java.util.UUID;

public record GameAction(String playerId, int minute, int action, int score) {

    public GameAction(String playerId, int minute, int action, int score) {
        this.playerId = UUID.randomUUID().toString();
        this.minute = minute;
        this.action = action;
        this.score = score;
    }
}
