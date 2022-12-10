package com.fredsonchaves07.msconsolidacao.api.infra.config;

import com.fredsonchaves07.msconsolidacao.api.infra.repositories.PlayerRepository;
import com.fredsonchaves07.msconsolidacao.domain.useCases.ListPlayersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    public PlayerRepository playerRepository;

    @Bean
    public ListPlayersUseCase listPlayersUseCase() {
        return new ListPlayersUseCase(playerRepository);
    }
}
