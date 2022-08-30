package com.Desafio.GerConta.repository;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContasAPagarModel, Long> {

   List<ContasAPagarModel> findByTipoConta(TipoEnum tipoConta);

   List<ContasAPagarModel> findByStatus(StatusEnum status);

}
