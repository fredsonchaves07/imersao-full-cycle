package com.fredsonchaves07.msconsolidacao.api.resources;

import com.fredsonchaves07.msconsolidacao.api.services.GetMatchByIdService;
import com.fredsonchaves07.msconsolidacao.domain.useCases.output.MatchOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/matches/{id}")
public class GetMatchByIdResource {

    @Autowired
    GetMatchByIdService service;

    @GetMapping
    public ResponseEntity<MatchOutput> getMatchById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.execute(id));
    }
}
