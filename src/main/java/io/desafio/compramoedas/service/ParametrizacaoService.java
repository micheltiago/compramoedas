package io.desafio.compramoedas.service;

import io.desafio.compramoedas.domain.Moeda;
import io.desafio.compramoedas.domain.Parametrizacao;
import io.desafio.compramoedas.dto.MoedaDTO;
import io.desafio.compramoedas.dto.ParametrizacaoDTO;
import io.desafio.compramoedas.repository.MoedaRepository;
import io.desafio.compramoedas.repository.ParametroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ParametrizacaoService {

    private final MoedaRepository moedaRep;
    private final ParametroRepository parametroRep;

    public Mono<Parametrizacao> saveParam(ParametrizacaoDTO dto) {
        return Mono.just(
                this.parametroRep
                        .save(Parametrizacao
                                .builder()
                                .segmento(dto.getSegmento().getTipo())
                                .taxa(dto.getTaxa())
                                .build()))
                ;
    }

    public Mono<Moeda> saveMoeda(MoedaDTO dto) {
        return Mono.just(
                this.moedaRep
                        .save(Moeda
                                .builder()
                                .taxa(dto.getTaxa())
                                .tipo(dto.getMoeda().getNome())
                                .build()))
                ;
    }

    public Flux<Parametrizacao> getParamAll() {
        return Flux.fromStream(
                this.parametroRep
                        .findAll()
                        .stream())
                ;
    }

    public Flux<Moeda> getMoedaAll() {
        return Flux.fromStream(
                this.moedaRep
                        .findAll()
                        .stream())
                ;
    }

}
