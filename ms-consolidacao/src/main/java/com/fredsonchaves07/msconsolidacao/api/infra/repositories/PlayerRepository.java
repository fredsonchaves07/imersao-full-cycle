package com.fredsonchaves07.msconsolidacao.api.infra.repositories;

import com.fredsonchaves07.msconsolidacao.api.infra.entities.PlayerJpaEntity;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.api.infra.repositories.jpa.PlayerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PlayerRepository implements PlayerRepositoryInterface {

    @Autowired
    private PlayerJpaRepository repository;

    @Override
    public Player findById(UUID id) {
        return repository
                .findById(id.toString())
                .map(player -> new Player(UUID.fromString(player.getId()), player.getName(), player.getPrice())).get();
    }

    @Override
    public void create(Player player) {
        PlayerJpaEntity playerJpaEntity = new PlayerJpaEntity(player.getId().toString(), player.getName(), player.getPrice());
        repository.save(playerJpaEntity);
    }

    @Override
    public void update(Player player) {
        PlayerJpaEntity playerJpaEntity = new PlayerJpaEntity(player.getId().toString(), player.getName(), player.getPrice());
        repository.save(playerJpaEntity);
    }

    @Override
    public List<Player> findAll() {
        return repository
                .findAll()
                .stream().map(player -> new Player(UUID.fromString(player.getId()), player.getName(), player.getPrice())).toList();
    }

    @Override
    public List<Player> findAllByIds(List<UUID> ids) {
        return repository
                .findAllById(ids.stream().map(UUID::toString).collect(Collectors.toSet()))
                .stream().map(player -> new Player(UUID.fromString(player.getId()), player.getName(), player.getPrice())).toList();
    }
}
