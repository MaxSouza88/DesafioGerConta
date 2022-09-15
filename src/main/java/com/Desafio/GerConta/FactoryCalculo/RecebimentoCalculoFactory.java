package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.enums.TipoPagamento;

@Deprecated
public class RecebimentoCalculoFactory {

    public RecebimentoCalculo construir (ContasReceberModel contasReceberModel){
        if(contasReceberModel.getTipoPagamento() == TipoPagamento.EM_ATRASO){
            return new RecebimentoAtraso();
        } else if (contasReceberModel.getTipoPagamento() == TipoPagamento.ADIANTADO) {
            return new RecebimentoAdiantado();
        } else if (contasReceberModel.getTipoPagamento() == TipoPagamento.EM_DIA) {
            return new RecebimentoEmDia();
        }else {
            throw new IllegalArgumentException("Nao foi possivel determinar ");
        }
    }
}
