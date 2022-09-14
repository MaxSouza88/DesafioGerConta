package com.Desafio.GerConta.model;

import com.Desafio.GerConta.model.enums.RecebimentoAlugueis;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contasReceber")
public class ContasReceberModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recebimento", length = 100, nullable = false)
    private String recebimento;

    @Column(name = "valor_recebido", length = 10, nullable = false)
    private BigDecimal valorRecebido;

    @Enumerated(value = EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_recebimento")
    private LocalDateTime dataDeRecebimento;

    @Enumerated(value = EnumType.STRING)
    private RecebimentoAlugueis receber;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private UsuarioModel usuario;

}
