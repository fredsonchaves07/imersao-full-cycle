package com.fredsonchaves07.msconsolidacao.domain.useCases.input;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AddMatchInput(UUID id, OffsetDateTime date, UUID teamAId, UUID teamBId) { }
