package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gerenciador")

public class ContasAPagarModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_Conta", length = 100, nullable = false)
    private String nomeConta;

    @Column(name = "valor", length = 10, nullable = false)
    private double valor;

    @Enumerated(value = EnumType.STRING)
    private TipoEnum tipoConta;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_pagamento")
    private LocalDateTime dataDePagamento;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;

}
