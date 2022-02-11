package io.desafio.compramoedas.service;

import io.desafio.compramoedas.enumeration.MoedaEnum;
import io.desafio.compramoedas.enumeration.SegmentoEnum;
import io.desafio.compramoedas.repository.MoedaRepository;
import io.desafio.compramoedas.repository.ParametroRepository;
import io.desafio.compramoedas.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CotacaoServiceTest {

    @Mock
    private MoedaRepository moedaRep;
    @Mock
    private ParametroRepository parametroRep;

    @InjectMocks
    private CotacaoService service;

    @Test
    void getCotacaoSuccess(){

        Integer qtd = 45;
        MoedaEnum moeda = MoedaEnum.EUR;
        SegmentoEnum segmento = SegmentoEnum.PRIVATE;

        when(this.moedaRep.findFirstByTipo(any())).thenReturn(Optional.of(Constants.moeda01()));
        when(this.parametroRep.findFirstBySegmento(any())).thenReturn(Optional.of(Constants.parametrizacao01()));

        Mono<Double> cotacao = service.getCotacao(qtd, moeda, segmento);

        StepVerifier.create(cotacao)
                .consumeNextWith( it ->{
                    assertNotNull(it);
                    assertEquals(Double.parseDouble("561.6"), it);
                })
                .verifyComplete()
        ;

        Mockito.verify(moedaRep).findFirstByTipo(moeda.getNome());
        Mockito.verify(parametroRep).findFirstBySegmento(segmento.getTipo());

    }

}
