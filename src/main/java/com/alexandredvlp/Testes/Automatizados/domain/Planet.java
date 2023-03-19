package com.alexandredvlp.Testes.Automatizados.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planets")
public class Planet {

    public Planet(String nome, String terrain, String climate) {
        this.nome = nome;
        this.terrain = terrain;
        this.climate = climate;
    }
    public Planet( String terrain, String climate) {
        this.terrain = terrain;
        this.climate = climate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String terrain;
    private String climate;

}
