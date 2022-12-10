package com.fredsonchaves07.msconsolidacao.api.services;

import com.fredsonchaves07.msconsolidacao.domain.useCases.ListPlayersUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPlayersService {

    @Autowired
    private ListPlayersUseCase listPlayersUseCase;

    public List<PlayerOutput> execute() {
        return listPlayersUseCase.execute();
    }
}
