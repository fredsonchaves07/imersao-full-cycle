package com.fredsonchaves07.msconsolidacao.api.services;

import com.fredsonchaves07.msconsolidacao.domain.useCases.GetMatchByIdUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.MyTeamPlayersUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetMatchByIdService {

    @Autowired
    private GetMatchByIdUseCase useCase;

    public MatchOutput execute(String id) {
        return useCase.execute(UUID.fromString(id));
    }
}
