package com.fredsonchaves07.msconsolidacao.domain.entity;

import java.math.BigDecimal;

public class Player {

    private String id;

    private String name;

    private BigDecimal price;

    public Player() {

    }

    public Player(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
