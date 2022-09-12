package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.CidadeModel;
import com.Desafio.GerConta.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> buscarCidade(){

        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarCidadeId(Long id){

        return cidadeRepository.findById(id);
    }

    public CidadeModel cadastraCidade(CidadeModel cidadeModel){

        return cidadeRepository.save(cidadeModel);
    }

    public CidadeModel alteraCadCidade (CidadeModel cidadeModel){

        return cidadeRepository.save(cidadeModel);
    }

    public void deletaCidade(Long id){

        cidadeRepository.deleteById(id);
    }
}
