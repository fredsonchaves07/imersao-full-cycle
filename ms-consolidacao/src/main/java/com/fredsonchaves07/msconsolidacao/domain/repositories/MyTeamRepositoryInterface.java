package com.fredsonchaves07.msconsolidacao.domain.repositories;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.entities.Team;

import java.util.List;
import java.util.UUID;

public interface MyTeamRepositoryInterface {

    MyTeam findById(UUID id);

    void addScore(double score);

    void create(MyTeam myTeam);

    List<Player> findAllPlayers(Team team);

    void savePlayers(MyTeam myTeam);

    void update(MyTeam myTeam);
}
