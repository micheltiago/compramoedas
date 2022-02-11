package io.desafio.compramoedas.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyCalcTest {

    private final MyCalc calc = new MyCalc();

    @Test
    void calcularSuccess() {

        Integer qtd = 10;
        Double taxaMoeda = Double.parseDouble("1.78");
        Double taxaSegmeno = Double.parseDouble("2.54");

        double expected = Double.parseDouble("63.012");

        Double result = calc.calcular(qtd, taxaMoeda, taxaSegmeno);

        assertEquals(expected, result);
    }
}
