package com.fredsonchaves07.msconsolidacao.domain.entities;

import java.util.UUID;

public class Player {

    private UUID id;

    private String name;

    private int price;

    public Player() {

    }

    public Player(UUID id, String name, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
