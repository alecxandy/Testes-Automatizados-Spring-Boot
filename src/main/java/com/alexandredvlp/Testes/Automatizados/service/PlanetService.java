package com.alexandredvlp.Testes.Automatizados.service;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import com.alexandredvlp.Testes.Automatizados.domain.QueryBuilder;
import com.alexandredvlp.Testes.Automatizados.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return planetRepository.save(planet);
    }

    public Optional<Planet> get(Long id) {
        return planetRepository.findById(id);
    }

    public Optional<Planet> getByName(String name) {
        return planetRepository.findByName(name);
    }

    public List<Planet> list(String terrain, String climate) {
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(climate, terrain));
        return planetRepository.findAll(query);
    }

    public void remove(Long id) {
        planetRepository.deleteById(id);
    }

}
