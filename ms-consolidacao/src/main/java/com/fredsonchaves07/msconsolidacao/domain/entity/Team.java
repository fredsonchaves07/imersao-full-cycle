package com.fredsonchaves07.msconsolidacao.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String id;

    private String name;

    private List<Player> players;

    public Team() {

    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
