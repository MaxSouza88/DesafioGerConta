package com.Desafio.GerConta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cidade")

public class CidadeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cidade", nullable = false)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "nome_estado",referencedColumnName = "id")
    private EstadoModel estado ;
}
