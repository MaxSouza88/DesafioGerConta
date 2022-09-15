package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;

import java.math.BigDecimal;

public class RecebimentoAdiantado implements RecebimentoCalculo{

    @Override
    public BigDecimal calcularRecebimento(ContasReceberModel contasReceberModel) {
        BigDecimal antecipado = contasReceberModel.getValorRecebido().multiply(new BigDecimal(String.valueOf(0.05)));
        return contasReceberModel.getValorRecebido().subtract(antecipado);

    }
}
