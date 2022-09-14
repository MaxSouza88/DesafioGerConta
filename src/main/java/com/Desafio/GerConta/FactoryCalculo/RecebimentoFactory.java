package com.Desafio.GerConta.FactoryCalculo;

import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.enums.RecebimentoAlugueis;

public class RecebimentoFactory {

    public RecebimentoCalculo recebimentoAlugueis (ContasReceberModel contasReceberModel){
        if(recebimentoAlugueis == recebimentoAlugueis.EM_ATRASO){
            return new RecebimentoAtraso();
        } else if (recebimentoAlugueis == recebimentoAlugueis.ADIANTADO) {
            return new RecebimentoAdiantado();
        } else if (recebimentoAlugueis == recebimentoAlugueis.EM_DIA) {
            return new RecebimentoEmDia();
        }else {
            return null;
        }
    }
}
