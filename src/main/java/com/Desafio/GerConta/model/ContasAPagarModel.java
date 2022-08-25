package com.Desafio.GerConta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gerenciador")

public class ContasAPagarModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "valor", length = 10,nullable = false)
    private double valor;

    @Column
    private String tipoConta;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    @Column
    private LocalDateTime dataDePagamento;


}
