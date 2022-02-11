package io.desafio.compramoedas.repository;

import io.desafio.compramoedas.domain.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MoedaRepository extends JpaRepository<Moeda, String> {

    Optional<Moeda> findFirstByTipo(String tipo);

}
