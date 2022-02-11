package io.desafio.compramoedas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARAMETRO")
public class Parametrizacao implements Serializable {

    @Id
    @Column(name = "SEGMENTO")
    private String segmento;

    @Column(name = "TAXA")
    private Double taxa;

}
