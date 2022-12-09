package com.fredsonchaves07.msconsolidacao.domain.repositories;

import com.fredsonchaves07.msconsolidacao.domain.entities.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerRepositoryInterface {

    Player findById(UUID id);

    void create(Player player);

    void update(Player player);

    List<Player> findAll();

    List<Player> findAllByIds(List<UUID> ids);
}
