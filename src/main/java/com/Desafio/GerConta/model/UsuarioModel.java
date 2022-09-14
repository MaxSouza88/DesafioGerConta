package com.Desafio.GerConta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email")
    @Email(message = "Email inválido !")
    @NotBlank(message = "Email nao informado !!")
    private String email;

    @Column(name = "cpf")
    @CPF(message = "CPF informado, está inválido !")
    @NotBlank(message = "CPF não informado ")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoModel endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContasReceberModel> contasReceberModels = new ArrayList<>();

}
