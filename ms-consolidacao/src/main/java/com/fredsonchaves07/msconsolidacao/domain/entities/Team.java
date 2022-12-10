package com.fredsonchaves07.msconsolidacao.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {

    private UUID id;

    private String name;

    private List<Player> players;

    public Team() {

    }

    public Team(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
