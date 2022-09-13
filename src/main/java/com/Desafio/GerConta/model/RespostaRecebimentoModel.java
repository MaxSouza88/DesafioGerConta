package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaRecebimentoModel {

    private Long id;
    private String nomeRecebimento;
    private BigDecimal valorRecebimento;
    private StatusEnum status;

}
