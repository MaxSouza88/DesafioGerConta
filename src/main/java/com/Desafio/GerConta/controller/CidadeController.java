package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.CidadeModel;
import com.Desafio.GerConta.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public Iterable<CidadeModel> buscaTudo(){

        return cidadeService.buscarCidade();
    }

    @GetMapping(path = "/cidades/{id}")
    public Optional<CidadeModel> buscaId(@PathVariable Long id){

        return cidadeService.buscarCidadeId(id);
    }

    @PostMapping(path = "/cidades")
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel cadastraCidade (@RequestBody CidadeModel cidadeModel){

        return cidadeService.cadastraCidade(cidadeModel);
    }

    @PutMapping(path = "cidades/{codigo}")
    public CidadeModel alteraCidade(@ RequestBody CidadeModel cidadeModel){

        return cidadeService.alteraCadCidade(cidadeModel);
    }

    @DeleteMapping(path = "cidades/{id}")
    public void deletaCidade(@PathVariable Long id){

        cidadeService.deletaCidade(id);
    }
}
