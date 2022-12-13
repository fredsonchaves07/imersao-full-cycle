package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.Match;
import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.entities.Player;
import com.fredsonchaves07.msconsolidacao.domain.entities.enums.Actions;
import com.fredsonchaves07.msconsolidacao.domain.entities.records.GameAction;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MatchRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MyTeamRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.repositories.PlayerRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.AddActionInput;

import java.util.UUID;

public class AddActionUseCase {

    MatchRepositoryInterface matchRepository;

    MyTeamRepositoryInterface myTeamRespository;

    PlayerRepositoryInterface playerRepository;

    public AddActionUseCase(
            MatchRepositoryInterface matchRepository,
            MyTeamRepositoryInterface myTeamRespository,
            PlayerRepositoryInterface playerRepository
    ) {
        this.matchRepository = matchRepository;
        this.myTeamRespository = myTeamRespository;
        this.playerRepository = playerRepository;
    }

    public void execute(AddActionInput input) {
        int score = getScoreByAction(input);
        setActionMatch(input, score);
        setPricePlayer(input, score);
        setScoreMyTeam(input, score);
    }


    private int getScoreByAction(AddActionInput input) {
        return Actions.valueOf(input.action()).getScore();
    }

    private void setActionMatch(AddActionInput input, int score) {
        Match match = getMatchById(input.matchId());
        GameAction gameAction = new GameAction(
                input.actionId(),
                input.playerId(),
                input.playerName(),
                input.teamId(),
                input.minute(),
                input.action(),
                score);
        match.setActions(gameAction);
        matchRepository.saveAction(match, score);
    }


    private Match getMatchById(UUID id) {
        return matchRepository.findById(id);
    }

    private void setPricePlayer(AddActionInput input, int score) {
        Player player = playerRepository.findById(input.playerId());
        player.setPrice(player.getPrice() + score);
        playerRepository.update(player);
    }

    private void setScoreMyTeam(AddActionInput input, int score) {
        MyTeam myTeam = myTeamRespository.findById(input.teamId());
        myTeam.setScore(score);
        myTeamRespository.update(myTeam);
    }
}
