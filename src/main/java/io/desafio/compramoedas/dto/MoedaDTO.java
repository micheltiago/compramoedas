package io.desafio.compramoedas.dto;

import io.desafio.compramoedas.enumeration.MoedaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class MoedaDTO {
    @NotNull
    private Double taxa;
    @NotNull
    private MoedaEnum moeda;
}
