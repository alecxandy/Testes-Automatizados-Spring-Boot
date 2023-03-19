package com.alexandredvlp.Testes.Automatizados.controller;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import com.alexandredvlp.Testes.Automatizados.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Optional<Planet>> findByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(planetService.getByName(nome));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(Long id) {
        return planetService.get(id).map(planet -> ResponseEntity.status(HttpStatus.OK).body(planet))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        planetService.remove(id);
    }

}
