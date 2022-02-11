package io.desafio.compramoedas.controller;

import io.desafio.compramoedas.enumeration.MoedaEnum;
import io.desafio.compramoedas.enumeration.SegmentoEnum;
import io.desafio.compramoedas.service.CotacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(controllers = CotacaoController.class, excludeAutoConfiguration = {ReactiveSecurityAutoConfiguration.class})
public class CotacaoControllerTest {

    @MockBean
    private CotacaoService service;

    @Autowired
    private WebTestClient client;

    @Test
    void getCotacaoSuccess() {

        Integer qtd = 45;
        MoedaEnum moeda = MoedaEnum.EUR;
        SegmentoEnum segmento = SegmentoEnum.PRIVATE;

        when(service.getCotacao(qtd, moeda, segmento)).thenReturn(Mono.just(Double.parseDouble("362.00")));

        this.client
                .get()
                .uri("/v1/cotacao/qtd/{qtd}/moeda/{moeda}/segmento/{segmento}/", qtd, moeda, segmento)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
        ;

        Mockito.verify(service).getCotacao(qtd, moeda, segmento);
    }

}
