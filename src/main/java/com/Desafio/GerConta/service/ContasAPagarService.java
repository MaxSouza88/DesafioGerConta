package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarModel> buscarTudo(){
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscaPorId(Long id){
        return contasAPagarRepository.findById(id);
    }

    public ContasAPagarModel cadastraConta(ContasAPagarModel contasAPagarModel){

        contasAPagarModel.getNome();
        contasAPagarModel.getValor();
        contasAPagarModel.getTipoConta();
        contasAPagarModel.getDataDeVencimento();

        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alteraConta(ContasAPagarModel contasAPagarModel){
        contasAPagarModel.getNome();
        contasAPagarModel.getValor();
        contasAPagarModel.getTipoConta();
        contasAPagarModel.getDataDeVencimento();

        return contasAPagarRepository.save(contasAPagarModel);
    }

    public void deletaConta(Long id){
        contasAPagarRepository.deleteById(id);
    }


}
