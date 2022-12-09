package com.fredsonchaves07.msconsolidacao.infra.repositories;

import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.infra.entities.PlayerJpaEntity;
import com.fredsonchaves07.msconsolidacao.infra.repositories.jpa.PlayerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PlayerRepository implements PlayerRepositoryInterface {

    @Autowired
    private PlayerJpaRepository jpaRepository;

    @Override
    public Player findById(UUID id) {
        return jpaRepository
                .findById(id)
                .map(player -> new Player(player.getId(), player.getName(), player.getPrice())).get();
    }

    @Override
    public void create(Player player) {
        PlayerJpaEntity playerJpaEntity = new PlayerJpaEntity(player.getId(), player.getName(), player.getPrice());
        jpaRepository.save(playerJpaEntity);
    }

    @Override
    public void update(Player player) {
        PlayerJpaEntity playerJpaEntity = new PlayerJpaEntity(player.getId(), player.getName(), player.getPrice());
        jpaRepository.save(playerJpaEntity);
    }

    @Override
    public List<Player> findAll() {
        return jpaRepository
                .findAll()
                .stream().map(player -> new Player(player.getId(), player.getName(), player.getPrice())).toList();
    }

    @Override
    public List<Player> findAllByIds(List<UUID> ids) {
        return jpaRepository
                .findAllById(ids)
                .stream().map(player -> new Player(player.getId(), player.getName(), player.getPrice())).toList();
    }
}
