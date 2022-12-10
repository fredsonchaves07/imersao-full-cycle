package com.fredsonchaves07.msconsolidacao.domain.services;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;

import java.util.List;

public class MyTeamChoosePlayersService {

    int totalCost;

    int totalEarned;

    public void execute(MyTeam myTeam, List<Player> myPlayers, List<Player> players) {
        totalEarned = calculateTotalEarned(myPlayers, players);
        for (Player player : players) {
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

    private int calculateTotalEarned(List<Player> myPLayers, List<Player> players) {
        int totalEarned = 0;
        for (Player player: players) {
            if (!playerInPlayersList(player, players)) {
                totalEarned += player.getPrice();
            }
        }
        return totalEarned;
    }
}
