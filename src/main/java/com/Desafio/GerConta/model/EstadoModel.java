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
@Table(name = "estado")

public class EstadoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uf")
    private String uf;

    @Column(name = "nome_estado", nullable = false)
    private String nomeEstado;

    @JsonIgnore
    @OneToMany(mappedBy = "estado",cascade = CascadeType.ALL)
    private List<CidadeModel> cidadeModel = new ArrayList<>();


}
