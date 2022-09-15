package com.Desafio.GerConta.model;
import com.Desafio.GerConta.model.enums.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaSelecionadaModel {

    private Long id;
    private String nome;
    private double valor;
    private StatusPagamento status;

}
