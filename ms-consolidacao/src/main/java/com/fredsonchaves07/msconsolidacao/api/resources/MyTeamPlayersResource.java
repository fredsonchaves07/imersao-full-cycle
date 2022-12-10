package com.fredsonchaves07.msconsolidacao.api.resources;

import com.fredsonchaves07.msconsolidacao.api.services.MyTeamPlayersService;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/my-team/{id}/players")
public class MyTeamPlayersResource {

    @Autowired
    private MyTeamPlayersService myTeamPlayersService;

    @GetMapping()
    public ResponseEntity<List<PlayerOutput>> myTeamPlayers(@PathVariable String id) {
        return ResponseEntity.ok().body(myTeamPlayersService.execute(id));
    }
}
