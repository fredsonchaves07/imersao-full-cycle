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

    public MyTeam(UUID id, String name, List<Player> players, int score) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
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
