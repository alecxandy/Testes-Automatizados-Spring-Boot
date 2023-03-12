package com.alexandredvlp.Testes.Automatizados.common;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;

//classe pra criar constantes de planetas
//essa classe vai servi de dados pra usar em nossos testes
public class PlanetConstant {
    public static final Planet PLANET = new Planet("name", "climate", "terrain");
    public static final Planet INVALID_PLANET = new Planet("", "", "");
}
