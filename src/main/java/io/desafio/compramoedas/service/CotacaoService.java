package io.desafio.compramoedas.service;

import io.desafio.compramoedas.domain.Moeda;
import io.desafio.compramoedas.domain.Parametrizacao;
import io.desafio.compramoedas.enumeration.MoedaEnum;
import io.desafio.compramoedas.enumeration.SegmentoEnum;
import io.desafio.compramoedas.repository.MoedaRepository;
import io.desafio.compramoedas.repository.ParametroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import static io.desafio.compramoedas.util.MyCalc.calcular;

@Service
@AllArgsConstructor
public class CotacaoService {

    private final MoedaRepository moedaRep;
    private final ParametroRepository parametroRep;

    public Mono<Double> getCotacao(Integer qtd, MoedaEnum moeda, SegmentoEnum segmento) {
        return Mono.just(
                this.build(qtd, moeda, segmento))
                ;
    }

    private Double build(Integer qtd, MoedaEnum moe, SegmentoEnum seg) {
        return calcular(
                qtd,
                this.buildTaxaMoeda(moe),
                this.buildTaxaSegmento(seg))
                ;
    }

    private Double buildTaxaMoeda(MoedaEnum moe) {
        return this.moedaRep
                .findFirstByTipo(moe.getNome())
                .map(Moeda::getTaxa)
                .orElse(Double.parseDouble("0"))
                ;
    }

    private Double buildTaxaSegmento(SegmentoEnum seg) {
        return this.parametroRep
                .findFirstBySegmento(seg.getTipo())
                .map(Parametrizacao::getTaxa)
                .orElse(Double.parseDouble("0"))
                ;
    }

}
