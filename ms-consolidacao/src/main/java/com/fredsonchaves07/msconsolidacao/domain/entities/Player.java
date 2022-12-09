package com.fredsonchaves07.msconsolidacao.domain.entities;

import java.util.UUID;

public class Player {

    private UUID id;

    private String name;

    private double price;

    public Player() {

    }

    public Player(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
