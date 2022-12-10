package com.fredsonchaves07.msconsolidacao.api.infra.repositories;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.MyTeamJpaEntity;
import com.fredsonchaves07.msconsolidacao.api.infra.entities.PlayerJpaEntity;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa.MyTeamJpaRepository;
import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MyTeamRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MyTeamRepository implements MyTeamRepositoryInterface {

    @Autowired
    private MyTeamJpaRepository repository;

    @Override
    public MyTeam findById(UUID id) {
        MyTeamJpaEntity myTeamJpa = repository.findById(id.toString()).get();
        List<Player> players = myTeamJpa.getPlayers()
                .stream()
                .map(player -> new Player(UUID.fromString(player.getId()), player.getName(), player.getPrice()))
                .toList();
        return new MyTeam(UUID.fromString(myTeamJpa.getId()) , myTeamJpa.getName(), players, myTeamJpa.getScore());
    }

    @Override
    public void addScore(int score) {
        //TODO -> Method implementation
    }

    @Override
    public void create(MyTeam myTeam) {
        Set<PlayerJpaEntity> players = myTeam.getPlayers()
                .stream()
                .map(player -> new PlayerJpaEntity(player.getId().toString(), player.getName(), player.getPrice()))
                .collect(Collectors.toSet());
        MyTeamJpaEntity myTeamJpa = new MyTeamJpaEntity(myTeam.getId().toString(), myTeam.getName(), players, myTeam.getScore());
        repository.save(myTeamJpa);
    }

    @Override
    public List<Player> findAllPlayers(MyTeam myTeam) {
        MyTeamJpaEntity myTeamJpa = repository.findById(myTeam.getId().toString()).get();
        return myTeamJpa.getPlayers()
                .stream()
                .map(player -> new Player(UUID.fromString(player.getId()), player.getName(), player.getPrice()))
                .toList();
    }

    @Override
    public void savePlayers(MyTeam myTeam) {
        //TODO -> Method implementation
    }

    @Override
    public void update(MyTeam myTeam) {
        Set<PlayerJpaEntity> players = myTeam.getPlayers()
                .stream()
                .map(player -> new PlayerJpaEntity(player.getId().toString(), player.getName(), player.getPrice()))
                .collect(Collectors.toSet());
        MyTeamJpaEntity myTeamJpa = new MyTeamJpaEntity(myTeam.getId().toString(), myTeam.getName(), players, myTeam.getScore());
        repository.save(myTeamJpa);
    }
}
