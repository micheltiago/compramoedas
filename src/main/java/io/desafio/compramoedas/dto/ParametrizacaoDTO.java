package io.desafio.compramoedas.dto;

import io.desafio.compramoedas.enumeration.MoedaEnum;
import io.desafio.compramoedas.enumeration.SegmentoEnum;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ParametrizacaoDTO {
    @NotNull
    private Double taxa;
    @NotNull
    private SegmentoEnum segmento;
}
