package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.enums.RecebimentoAlugueis;
import org.springframework.stereotype.Component;

@Component
public class RecebimentoFactory {

    public RecebimentoCalculo construir (ContasReceberModel contasReceberModel){
        if(contasReceberModel.getTipoPagamento() == RecebimentoAlugueis.EM_ATRASO){
            return new RecebimentoAtraso();
        } else if (contasReceberModel.getTipoPagamento() == RecebimentoAlugueis.ADIANTADO) {
            return new RecebimentoAdiantado();
        } else if (contasReceberModel.getTipoPagamento() == RecebimentoAlugueis.EM_DIA) {
            return new RecebimentoEmDia();
        }else {
            throw new IllegalArgumentException("Nao foi possivel determinar ");
        }
    }
}
