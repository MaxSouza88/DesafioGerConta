package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @GetMapping
    public List<ContasAPagarModel> buscarTudo(){
        return contasAPagarService.buscarTudo();
    }

    @GetMapping(path = "/{id}")
    public Optional<ContasAPagarModel> buscaId(@PathVariable Long id){
        return contasAPagarService.buscaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasAPagarModel cadastraConta(ContasAPagarModel contasAPagarModel){
        return contasAPagarService.cadastraConta(contasAPagarModel);
    }

    @PutMapping(path = "/{id}")
    public ContasAPagarModel alterarConta(@RequestBody ContasAPagarModel contasAPagarModel){
        return contasAPagarService.alteraConta(contasAPagarModel);
    }

    @DeleteMapping(path = "/{id}")
    public void deletaConta(@PathVariable Long id){
        contasAPagarService.deletaConta(id);
    }





}
