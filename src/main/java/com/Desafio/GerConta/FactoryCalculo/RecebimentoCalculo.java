package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;

import java.math.BigDecimal;

public interface RecebimentoCalculo {

    BigDecimal calcularRecebimento (ContasReceberModel contasReceberModel);
}
