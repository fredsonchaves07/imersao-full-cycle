package com.fredsonchaves07.msconsolidacao.api.infra.entities;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;

import javax.persistence.*;

@Entity
@Table(name = "actions")
public class ActionJpaEntity {

    @Id
    private String id;

    @Column(name = "action")
    private String action;

    @Column(name = "minute")
    private int minute;

    @Column(name = "score")
    private int score;

    @Column(name = "match_id")
    private String match_id;

    @Column(name = "team_id")
    private String team_id;

    @Column(name = "player_id")
    private String player_id;

    public ActionJpaEntity() {}

    public ActionJpaEntity(String id, String action, int minute, int score, String match_id, String team_id, String player_id) {
        this.id = id;
        this.action = action;
        this.minute = minute;
        this.score = score;
        this.match_id = match_id;
        this.team_id = team_id;
        this.player_id = player_id;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public int getMinute() {
        return minute;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public String getTeam_id() {
        return team_id;
    }
}
