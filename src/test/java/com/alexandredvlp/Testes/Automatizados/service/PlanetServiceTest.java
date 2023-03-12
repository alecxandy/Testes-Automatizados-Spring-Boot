package com.alexandredvlp.Testes.Automatizados.service;

import com.alexandredvlp.Testes.Automatizados.domain.Planet;
import com.alexandredvlp.Testes.Automatizados.repository.PlanetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.alexandredvlp.Testes.Automatizados.common.PlanetConstant.PLANET;
import static com.alexandredvlp.Testes.Automatizados.common.PlanetConstant.INVALID_PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//add mockito deixa a aplicação mais leve que a do springBootTest
public class PlanetServiceTest {

    @Mock
    private PlanetRepository planetRepository;
    @InjectMocks
    private PlanetService planetService;

    //como criar nome para os metodos: operacao_estado_retorno
    @Test
    @DisplayName("Deve salvar com sucesso")
    public void createPlanet_withValidation_returnsPlanet() {
        //Arange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);
        //Action
        Planet sut = planetService.create(PLANET);
        //Asserts
        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    @DisplayName("Retorna execeção caso receber null")
    public void createPlanet_withValidationData_TrowsException() {
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }


}
