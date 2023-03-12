package com.alexandredvlp.Testes.Automatizados.controller;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import com.alexandredvlp.Testes.Automatizados.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planetService.create(planet));
    }

}
