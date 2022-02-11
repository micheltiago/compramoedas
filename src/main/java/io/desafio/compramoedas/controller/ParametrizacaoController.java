package io.desafio.compramoedas.controller;

import io.desafio.compramoedas.domain.Moeda;
import io.desafio.compramoedas.domain.Parametrizacao;
import io.desafio.compramoedas.dto.MoedaDTO;
import io.desafio.compramoedas.dto.ParametrizacaoDTO;
import io.desafio.compramoedas.service.ParametrizacaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("v2/parametrizacao")
public class ParametrizacaoController {

    private final ParametrizacaoService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Parametrizacao> saveParam(@Valid @RequestBody ParametrizacaoDTO dto) {
        return this.service
                .saveParam(dto)
                .doOnNext(it -> log.info("Sucesso: {}", it))
                .doOnError(it -> log.error("Erro: {}", it.getMessage()))
                ;
    }

    @PostMapping("/moedas")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Moeda> saveMoeda(@Valid @RequestBody MoedaDTO dto) {
        return this.service
                .saveMoeda(dto)
                .doOnNext(it -> log.info("Sucesso: {}", it))
                .doOnError(it -> log.error("Erro: {}", it.getMessage()))
                ;
    }

    @GetMapping
    public Flux<Parametrizacao> getParams() {
        return this.service
                .getParamAll()
                .doOnNext(it -> log.info("Sucesso: {}", it))
                .doOnError(it -> log.error("Erro: {}", it.getMessage()))
                ;
    }

    @GetMapping("/moedas")
    public Flux<Moeda> getMoedas() {
        return this.service
                .getMoedaAll()
                .doOnNext(it -> log.info("Sucesso: {}", it))
                .doOnError(it -> log.error("Erro: {}", it.getMessage()))
                ;
    }

}
