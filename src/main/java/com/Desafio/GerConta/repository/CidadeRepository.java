package com.Desafio.GerConta.repository;

import com.Desafio.GerConta.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {

}
