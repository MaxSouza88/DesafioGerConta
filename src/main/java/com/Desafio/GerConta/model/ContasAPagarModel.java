package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
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
    private Long id;

    @Column(name = "nome_Conta", length = 100, nullable = false)
    private String nomeConta;

    @Column(name = "valor", length = 10, nullable = false)
    private double valor;

    @Column(length = 10, nullable = false)
    @Enumerated (value = EnumType.STRING)
    private TipoEnum tipoConta;

    @Column(name = "data_vencimento",length = 15,nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_pagamento",length = 15)
    private LocalDateTime dataDePagamento;

    @Column
    @Enumerated (value = EnumType.STRING)
    private StatusEnum status;







}
