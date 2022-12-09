package com.fredsonchaves07.msconsolidacao.domain.entities;

import java.util.List;

public class MyTeam {

    private String id;

    private String name;

    private List<Player> players;

    private double score;

    public MyTeam(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
