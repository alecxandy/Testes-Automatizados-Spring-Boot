package com.alexandredvlp.Testes.Automatizados.service;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import com.alexandredvlp.Testes.Automatizados.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }
}
