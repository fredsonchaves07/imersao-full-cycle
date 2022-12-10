package com.fredsonchaves07.msconsolidacao.api.infra.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "my_team")
public class MyTeamJpaEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int score;

    @ManyToMany
    @JoinTable(
            name = "my_team_players",
            joinColumns = @JoinColumn(name = "my_team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<PlayerJpaEntity> players = new HashSet<>();

    public MyTeamJpaEntity() {

    }

    public MyTeamJpaEntity(String id, String name, Set<PlayerJpaEntity> players, int price) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.score = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Set<PlayerJpaEntity> getPlayers() {
        return players;
    }

    public void setPlayers(PlayerJpaEntity player) {
        this.players.add(player);
    }
}
