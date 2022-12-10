package com.fredsonchaves07.msconsolidacao.domain.entities;

import com.fredsonchaves07.msconsolidacao.domain.entities.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.MatchResult;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Match {

    private UUID id;

    private Team teamA;

    private Team teamB;

    private UUID teamAId;

    private UUID teamBId;

    private OffsetDateTime date;

    private String status;

    private MatchResult matchResult;

    private final List<GameAction> actions = new LinkedList<>();

    public Match() {

    }

    public Match(UUID id, UUID teamAId, UUID teamBId, OffsetDateTime date) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.date = date;
    }

    public void setActions(GameAction gameAction) {
        this.actions.add(gameAction);
    }

    public MatchResult newMatchResult(int teamAScore, int teamBScore) {
        return new MatchResult(teamAScore, teamBScore);
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public String getResult(MatchResult matchResult) {
        return matchResult.teamAScore() + "-" + matchResult.teamBScore();
    }
}
