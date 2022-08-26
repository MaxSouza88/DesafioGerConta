package com.Desafio.GerConta.repository;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {

    public List<ContasAPagarModel> findByTipoConta (TipoEnum tipoConta);

   public List<ContasAPagarModel> findByStatusConta(StatusEnum status);

}
