package com.fredsonchaves07.msconsolidacao.domain.entities.enums;

public enum Actions {
    YELLOW_CARD(-1, "yellow_card"),
    RED_CARD(-3, "red_card"),
    GOAL(5, "goal");

    private final int score;

    private final String action;

    Actions(int score, String action) {
        this.score = score;
        this.action = action;
    }

    public int getScore() {
        return score;
    }
}
