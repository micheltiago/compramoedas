package io.desafio.compramoedas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOEDA")
public class Moeda {

    @Id
    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "TAXA")
    private Double taxa;
}
