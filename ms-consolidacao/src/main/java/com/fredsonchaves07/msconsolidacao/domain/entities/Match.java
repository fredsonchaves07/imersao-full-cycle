package com.fredsonchaves07.msconsolidacao.domain.entities;

import com.fredsonchaves07.msconsolidacao.domain.entities.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.MatchResult;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Match {

    private UUID id;

    private String teamAName;

    private String teamBName;

    private UUID teamAId;

    private UUID teamBId;

    private OffsetDateTime match_date;

    private String status;

    private MatchResult result;

    private final List<GameAction> actions = new LinkedList<>();

    public Match() {

    }

    public Match(UUID id, UUID teamAId, String teamAName, UUID teamBId, String teamBName, OffsetDateTime date) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamBId = teamBId;
        this.match_date = date;
    }

    public void setActions(GameAction gameAction) {
        this.actions.add(gameAction);
    }

    public MatchResult newMatchResult(int teamAScore, int teamBScore) {
        return new MatchResult(teamAScore, teamBScore);
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    public UUID getId() {
        return id;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public UUID getTeamAId() {
        return teamAId;
    }

    public UUID getTeamBId() {
        return teamBId;
    }

    public String getStatus() {
        return status;
    }

    public MatchResult getResult() {
        return result;
    }

    public List<GameAction> getActions() {
        return actions;
    }

    public OffsetDateTime getMatchDate() {
        return match_date;
    }

    public String getResult(MatchResult matchResult) {
        return matchResult.teamAScore() + "-" + matchResult.teamBScore();
    }
}
