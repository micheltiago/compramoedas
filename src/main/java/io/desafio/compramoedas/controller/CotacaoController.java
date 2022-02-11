package io.desafio.compramoedas.controller;

import io.desafio.compramoedas.enumeration.MoedaEnum;
import io.desafio.compramoedas.enumeration.SegmentoEnum;
import io.desafio.compramoedas.service.CotacaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("v1/cotacao")
public class CotacaoController {

    private final CotacaoService service;

    @GetMapping(path = "/qtd/{qtd}/moeda/{moeda}/segmento/{segmento}/")
    public Mono<Double> getCotacao(@PathVariable(name = "qtd", required = true) final Integer qtd,
                                   @PathVariable(name = "moeda", required = true) final MoedaEnum moeda,
                                   @PathVariable(name = "segmento", required = true) final SegmentoEnum segmento) {
        return this.service
                .getCotacao(qtd, moeda, segmento)
                .doOnNext(it -> log.info("Sucesso: {}", it))
                .doOnError(it -> log.error("Erro: {}", it.getMessage()))
                ;
    }
}
