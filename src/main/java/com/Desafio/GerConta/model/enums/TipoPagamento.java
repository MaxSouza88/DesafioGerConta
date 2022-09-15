package com.Desafio.GerConta.model.enums;

import com.Desafio.GerConta.FactoryCalculo.RecebimentoAdiantado;
import com.Desafio.GerConta.FactoryCalculo.RecebimentoAtraso;
import com.Desafio.GerConta.FactoryCalculo.RecebimentoCalculo;
import com.Desafio.GerConta.FactoryCalculo.RecebimentoEmDia;

public enum TipoPagamento {

    EM_ATRASO {
        @Override
        public RecebimentoCalculo getCalculo() {
            return new RecebimentoAtraso();
        }
    },

    EM_DIA {
        @Override
        public RecebimentoCalculo getCalculo() {
            return new RecebimentoEmDia();
        }
    },
    ADIANTADO {
        @Override
        public RecebimentoCalculo getCalculo() {
            return new RecebimentoAdiantado();
        }
    };

    public abstract RecebimentoCalculo getCalculo();
}
