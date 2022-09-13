package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;

import java.math.BigDecimal;

public class RecebimentoEmDia implements RecebimentoCalculo{
    @Override
    public BigDecimal calcularRecebimento(ContasReceberModel contasReceberModel) {
        return contasReceberModel.getValorRecebido();
    }
}
