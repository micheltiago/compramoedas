package io.desafio.compramoedas.repository;

import io.desafio.compramoedas.domain.Parametrizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface  ParametroRepository extends JpaRepository<Parametrizacao, String> {

    Optional<Parametrizacao> findFirstBySegmento(String segmento);

}
