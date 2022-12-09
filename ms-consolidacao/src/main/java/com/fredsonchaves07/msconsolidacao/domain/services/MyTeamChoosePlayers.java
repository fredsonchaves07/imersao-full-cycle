package com.fredsonchaves07.msconsolidacao.domain.services;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;

import java.util.List;

public class MyTeamChoosePlayers {

    double totalCost = 0.0;

    double totalEarned = 0.0;

    public void execute(MyTeam myTeam, List<Player> players) {
        for (Player player : players) {
            if (playerInMyTeam(player, myTeam) && !playerInPlayersList(player, players)) {
                totalEarned += player.getPrice();
            }
            if (!playerInMyTeam(player, myTeam) && playerInPlayersList(player, players)) {
                totalEarned += player.getPrice();
            }
        }
        if (totalCost > myTeam.getScore()) {
            throw new RuntimeException("Not enough money");
        }
        myTeam.setScore(totalEarned - totalCost);
        myTeam.setPlayers(players);
    }

    private boolean playerInMyTeam(Player player, MyTeam myTeam) {
        return myTeam.getPlayers().contains(player);
    }

    private boolean playerInPlayersList(Player player, List<Player> players) {
        return players.contains(player);
    }
}
