package com.fredsonchaves07.msconsolidacao.api.infra.config;

import com.fredsonchaves07.msconsolidacao.api.infra.repositories.MatchRepository;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.MyTeamRepository;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.PlayerRepository;
import com.fredsonchaves07.msconsolidacao.domain.useCases.GetMatchByIdUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.ListMatchesUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.ListPlayersUseCase;
import com.fredsonchaves07.msconsolidacao.domain.useCases.MyTeamPlayersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public MyTeamRepository myTeamRepository;

    @Autowired
    public MatchRepository matchRepository;

    @Bean
    public ListPlayersUseCase listPlayersUseCase() {
        return new ListPlayersUseCase(playerRepository);
    }

    @Bean
    public MyTeamPlayersUseCase myTeamPlayersUseCase() {
        return new MyTeamPlayersUseCase(myTeamRepository);
    }

    @Bean
    public ListMatchesUseCase listMatchesUseCase() {
        return new ListMatchesUseCase(matchRepository);
    }

    @Bean
    public GetMatchByIdUseCase getMatchByIdUseCase() {
        return new GetMatchByIdUseCase(matchRepository);
    }
}
