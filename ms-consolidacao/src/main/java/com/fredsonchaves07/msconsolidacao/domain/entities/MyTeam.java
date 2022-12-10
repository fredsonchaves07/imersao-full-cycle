package com.fredsonchaves07.msconsolidacao.domain.entities;

import java.util.List;
import java.util.UUID;

public class MyTeam {

    private UUID id;

    private String name;

    private List<Player> players;

    private int score;

    public MyTeam(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
