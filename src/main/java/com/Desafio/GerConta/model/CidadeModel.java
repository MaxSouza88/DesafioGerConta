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
@Table(name = "cidade")

public class CidadeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cidade", nullable = false)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id",referencedColumnName = "id")
    private EstadoModel estado ;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade",cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco = new ArrayList<>();
}
