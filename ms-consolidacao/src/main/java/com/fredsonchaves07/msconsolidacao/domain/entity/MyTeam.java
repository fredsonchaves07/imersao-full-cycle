package com.fredsonchaves07.msconsolidacao.domain.entity;

import java.math.BigDecimal;
import java.util.List;

public class MyTeam {

    private String id;

    private String name;

    private List<String> players;

    private BigDecimal score;

    public MyTeam(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
