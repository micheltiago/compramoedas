package io.desafio.compramoedas.util;

import static java.lang.Double.parseDouble;
import static java.lang.Double.sum;

public class MyCalc {
    /**
     * X = ( qtd * taxaMoeda ) * ( 1 + taxaSegmeno )
     *
     * Onde:
     * X = valor em Reais
     * qtd = quantidade desejada da moeda estrangeira
     * taxaMoeda = taxa de conversão da moeda estrangeira para Real
     * taxaSegmeno = taxa parametrizada por segmento
     **/
    public static Double calcular(Integer qtd, Double taxaMoeda, Double taxaSegmeno) {
        double l = (qtd.doubleValue() * taxaMoeda);
        double d = sum(parseDouble("1"), taxaSegmeno);
        return (l * d);
    }
}
