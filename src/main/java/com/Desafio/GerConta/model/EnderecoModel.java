package com.Desafio.GerConta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")

public class EnderecoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro",nullable = false)
    private String logradouro;

    @Column(name = "bairro",nullable = false)
    private String bairro;

    @Column(name = "cep",nullable = false)
    private String cep;

    @Column(name = "referencia",nullable = false)
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private CidadeModel cidade;

   /* @JsonIgnore
    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
    private List<UsuarioModel> usuario = new ArrayList<>();*/

}
