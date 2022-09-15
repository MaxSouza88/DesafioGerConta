package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaRecebimentoModel {

    private Long id;
    private String nomeRecebimento;
    private BigDecimal valorRecebimento;
    private TipoRecebimento tipoRecebimento;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDeRecebimento;
    private StatusEnum status;
    private Long idUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }
}
