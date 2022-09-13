package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;

import java.math.BigDecimal;

public interface RecebimentoCalculo {

    public BigDecimal calcularRecebimento (ContasReceberModel contasReceberModel);
}
