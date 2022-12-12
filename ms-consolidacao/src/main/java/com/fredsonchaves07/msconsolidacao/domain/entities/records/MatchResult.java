package com.fredsonchaves07.msconsolidacao.domain.entities.records;

public record MatchResult(int teamAScore, int teamBScore) {
    @Override
    public String toString() {
        return teamAScore + "-" + teamBScore;
    }
}
