package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MyTeamRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.services.MyTeamChoosePlayersService;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.MyTeamChoosePlayersInput;

import java.util.List;

public class MyTeamChoosePlayersUseCase {

    MyTeamRepositoryInterface myTeamRepository;

    PlayerRepositoryInterface playerRepository;

    public MyTeamChoosePlayersUseCase(
            MyTeamRepositoryInterface myTeamRepositoryInterface,
            PlayerRepositoryInterface playerRepository
    ) {
        this.myTeamRepository = myTeamRepositoryInterface;
        this.playerRepository = playerRepository;
    }

    public void execute(MyTeamChoosePlayersInput input) {
        MyTeamChoosePlayersService service = new MyTeamChoosePlayersService();
        MyTeam myTeam = getMyTeam(input);
        List<Player> myPlayers = getPlayersMyTeam(myTeam);
        List<Player> players = getPlayers(input);
        service.execute(myTeam, myPlayers, players);
    }

    public MyTeam getMyTeam(MyTeamChoosePlayersInput input) {
        return myTeamRepository.findById(input.id());
    }

    public List<Player> getPlayersMyTeam(MyTeam myTeam) {
        return playerRepository.findAllByIds(myTeam.getPlayers().stream().map(Player::getId).toList());
    }

    public List<Player> getPlayers(MyTeamChoosePlayersInput input) {
        return playerRepository.findAllByIds(input.players().stream().map(Player::getId).toList());
    }
}
