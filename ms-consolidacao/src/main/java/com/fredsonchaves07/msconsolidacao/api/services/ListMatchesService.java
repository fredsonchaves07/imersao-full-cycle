package com.fredsonchaves07.msconsolidacao.api.services;

import com.fredsonchaves07.msconsolidacao.domain.useCases.ListMatchesUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMatchesService {

    @Autowired
    private ListMatchesUseCase listMatchesUseCase;

    public List<MatchOutput> execute() {
        return listMatchesUseCase.execute();
    }
}
