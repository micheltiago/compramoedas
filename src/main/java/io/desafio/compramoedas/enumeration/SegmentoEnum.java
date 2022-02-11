package io.desafio.compramoedas.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SegmentoEnum {
    VAREJO("VAREJO"),
    PERSONNALITE("PERSONNALITE "),
    PRIVATE("PRIVATE")
    ;

    @Getter
    private final String tipo;

}
