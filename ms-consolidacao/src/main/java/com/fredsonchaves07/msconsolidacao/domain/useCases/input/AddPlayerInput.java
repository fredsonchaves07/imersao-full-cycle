package com.fredsonchaves07.msconsolidacao.domain.useCases.input;

import java.util.UUID;

public record AddPlayerInput(UUID id, String name, int initialPrice) { }
