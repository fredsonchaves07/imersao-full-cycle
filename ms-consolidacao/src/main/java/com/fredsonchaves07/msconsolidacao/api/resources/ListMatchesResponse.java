package com.fredsonchaves07.msconsolidacao.api.resources;

import com.fredsonchaves07.msconsolidacao.api.services.ListMatchesService;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
public class ListMatchesResponse {

    @Autowired
    ListMatchesService listMatchesService;

    @GetMapping
    public ResponseEntity<List<MatchOutput>> listMatches() {
        return ResponseEntity.ok().body(listMatchesService.execute());
    }
}
