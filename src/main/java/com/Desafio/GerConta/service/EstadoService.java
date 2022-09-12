package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.EstadoModel;
import com.Desafio.GerConta.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoModel> buscarEstado(){

        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarEstadoId(Long id){

        return estadoRepository.findById(id);
    }

    public EstadoModel cadastraEstado(EstadoModel estadoModel){

        return estadoRepository.save(estadoModel);
    }

    public EstadoModel alteraCadEstado (EstadoModel estadoModel){

        return estadoRepository.save(estadoModel);
    }

    public void deletaEstado(Long id){

        estadoRepository.deleteById(id);
    }
}
