package com.Desafio.GerConta.repository;

import com.Desafio.GerConta.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}
