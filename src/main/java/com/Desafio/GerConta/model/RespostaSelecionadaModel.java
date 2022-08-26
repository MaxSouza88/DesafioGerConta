package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaSelecionadaModel {

    private Long id;
    private String nome;
    private double valor;
    private StatusEnum status;

}
