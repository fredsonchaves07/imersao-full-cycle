package com.fredsonchaves07.msconsolidacao.api.infra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "matches")
public class MatchJpaEntity {

    @Id
    private String id;

    @Column(name = "match_date")
    private OffsetDateTime matchDate;

    @Column(name = "team_a_id")
    private String teamAId;

    @Column(name = "team_a_name")
    private String teamAName;

    @Column(name = "team_b_id")
    private String teamBId;

    @Column(name = "team_b_name")
    private String teamBName;

    @Column(name = "result")
    private String result;

    public MatchJpaEntity(){}

    public MatchJpaEntity(String id, OffsetDateTime matchDate, String teamAId, String teamAName, String teamBId, String teamBName, String result) {
        this.id = id;
        this.matchDate = matchDate;
        this.teamAId = teamAId;
        this.teamAName = teamAName;
        this.teamBId = teamBId;
        this.teamBName = teamBName;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getMatchDate() {
        return matchDate;
    }

    public String getTeamAId() {
        return teamAId;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public String getTeamBId() {
        return teamBId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public String getResult() {
        return result;
    }
}
