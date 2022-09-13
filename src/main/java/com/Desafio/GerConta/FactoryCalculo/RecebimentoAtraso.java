package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;

import java.math.BigDecimal;

public class RecebimentoAtraso implements RecebimentoCalculo{
    @Override
    public BigDecimal calcularRecebimento(ContasReceberModel contasReceberModel) {
        BigDecimal atraso = contasReceberModel.getValorRecebido().multiply(new BigDecimal(String.valueOf(0.035)));
        return atraso.add(contasReceberModel.getValorRecebido());
    }
}
