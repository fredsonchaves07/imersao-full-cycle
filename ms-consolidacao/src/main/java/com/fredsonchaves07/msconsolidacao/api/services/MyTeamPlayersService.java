package com.fredsonchaves07.msconsolidacao.api.services;

import com.fredsonchaves07.msconsolidacao.domain.useCases.MyTeamPlayersUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MyTeamPlayersService {

    @Autowired
    private MyTeamPlayersUseCase myTeamPlayersUseCase;

    public List<PlayerOutput> execute(String id) {
        return myTeamPlayersUseCase.execute(UUID.fromString(id));
    }
}
