package com.fredsonchaves07.msconsolidacao.domain.useCases;

import com.fredsonchaves07.msconsolidacao.domain.entities.MyTeam;
import com.fredsonchaves07.msconsolidacao.domain.repositories.MyTeamRepositoryInterface;
import com.fredsonchaves07.msconsolidacao.domain.useCases.input.AddMyTeamInput;

public class AddMyTeamUseCase {

    MyTeamRepositoryInterface myTeamRepository;

    public AddMyTeamUseCase(MyTeamRepositoryInterface myTeamRepository) {
        this.myTeamRepository = myTeamRepository;
    }

    public void execute(AddMyTeamInput input) {
        myTeamRepository.create(createMyTeam(input));
    }

    private MyTeam createMyTeam(AddMyTeamInput input) {
        return new MyTeam(input.id(), input.name());
    }
}
