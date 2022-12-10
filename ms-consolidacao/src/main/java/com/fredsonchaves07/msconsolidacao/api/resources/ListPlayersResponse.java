package com.fredsonchaves07.msconsolidacao.api.resources;

import com.fredsonchaves07.msconsolidacao.api.services.ListPlayersService;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class ListPlayersResponse {

    @Autowired
    private ListPlayersService listPlayersService;

    @GetMapping()
    public ResponseEntity<List<PlayerOutput>> listPlayers() {
        return ResponseEntity.ok().body(listPlayersService.execute());
    }
}
