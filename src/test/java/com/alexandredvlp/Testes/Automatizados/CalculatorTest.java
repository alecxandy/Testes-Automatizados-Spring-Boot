package com.alexandredvlp.Testes.Automatizados;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void somaTest() {
        Calculator calculator = new Calculator();
        assertThat(calculator.soma(1, 3)).isEqualTo(4);
    }
}
