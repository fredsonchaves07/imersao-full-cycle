package com.fredsonchaves07.msconsolidacao.domain.useCases.output;

import com.fredsonchaves07.msconsolidacao.domain.entities.enums.Actions;

import java.time.OffsetDateTime;
import java.util.List;

public record MatchOutput(
        String id,
        String teamAId,
        String teamAName,
        String teamBId,
        String teamBName,
        OffsetDateTime date,
        String status,
        String result,
        List<MatchActionsOutput> actions
) { }
