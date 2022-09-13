package com.Desafio.GerConta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")

public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro",nullable = false)
    private String logradouro;

    @Column(name = "bairro",nullable = false)
    private String Bairro;

    @Column(name = "cep",nullable = false)
    private String cep;

    @Column(name = "referencia",nullable = false)
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private UsuarioModel usuario;

}
