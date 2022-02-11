package io.desafio.compramoedas.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MoedaEnum {
    AFN("AFN", "AFEGANISTAO"),
    ZAR("ZAR", "AFRICA DO SUL"),
    ALL("ALL", "ALBANIA, REPUBLICA DA"),
    DEM("DEM", "ALEMANHA"),
    ARS("ARS", "ARGENTINA"),
    EUR("EUR", "EUROPA"),
    ESP("ESP", "ESPANHA")
    ;

    @Getter
    private final String nome;
    @Getter
    private final String pais;
}