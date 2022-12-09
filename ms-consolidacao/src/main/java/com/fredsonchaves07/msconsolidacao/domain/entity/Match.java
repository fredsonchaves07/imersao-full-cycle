package com.fredsonchaves07.msconsolidacao.domain.entity;

import com.fredsonchaves07.msconsolidacao.domain.entity.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.entity.records.MatchResult;

import java.time.OffsetDateTime;
import java.util.List;

public class Match {

    private String id;

    private Team teamA;

    private Team teamB;

    private String teamAId;

    private String teamBId;

    private OffsetDateTime date;

    private String status;

    private MatchResult matchResult;

    private List<GameAction> action;

    public Match() {

    }

    public Match(String id, Team teamA, Team teamB, OffsetDateTime date) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
    }

    public MatchResult newMatchResult(int teamAScore, int teamBScore) {
        return new MatchResult(teamAScore, teamBScore);
    }

    public String getResult(MatchResult matchResult) {
        return matchResult.teamAScore() + "-" + matchResult.teamBScore();
    }
}
