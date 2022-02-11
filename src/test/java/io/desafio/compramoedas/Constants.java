package io.desafio.compramoedas;

import io.desafio.compramoedas.domain.Moeda;
import io.desafio.compramoedas.domain.Parametrizacao;

import java.util.List;

public class Constants {

    public static List<Moeda> moedas() {
        return List.of(moeda01(), moeda02());
    }

    public static Moeda moeda01() {
        return Moeda
                .builder()
                .tipo("EUR")
                .taxa(Double.parseDouble("1.2"))
                .build();
    }

    private static Moeda moeda02() {
        return Moeda
                .builder()
                .tipo("ESP")
                .taxa(Double.parseDouble("3.2"))
                .build();
    }

    public static List<Parametrizacao> parametrizacoes() {
        return List.of(parametrizacao01(), parametrizacao02());
    }

    public static Parametrizacao parametrizacao01() {
        return Parametrizacao
                .builder()
                .segmento("PRIVATE")
                .taxa(Double.parseDouble("9.4"))
                .build();
    }

    private static Parametrizacao parametrizacao02() {
        return Parametrizacao
                .builder()
                .segmento("PERSONNALITE")
                .taxa(Double.parseDouble("4.7"))
                .build();
    }
}
