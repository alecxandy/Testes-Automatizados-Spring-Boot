package com.alexandredvlp.Testes.Automatizados.repository;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
