package com.Desafio.GerConta.repository;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceberModel,Long> {

    List<ContasReceberModel> findBytipoRecebimento(TipoRecebimento tipoRecebimento);

    List<ContasReceberModel> findByStatus(StatusEnum status);

}
