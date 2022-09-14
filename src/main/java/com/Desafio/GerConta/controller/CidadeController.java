package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.CidadeModel;
import com.Desafio.GerConta.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @GetMapping
    public Iterable<CidadeModel> buscaTudo(){

        return cidadeService.buscarCidade();
    }

    @GetMapping(path = "/{id}")
    public Optional<CidadeModel> buscaId(@PathVariable Long id){

        return cidadeService.buscarCidadeId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel cadastraCidade (@RequestBody CidadeModel cidadeModel){

        return cidadeService.cadastraCidade(cidadeModel);
    }

    @PutMapping(path = "/{id}")
    public CidadeModel alteraCidade(@ RequestBody CidadeModel cidadeModel){

        return cidadeService.alteraCadCidade(cidadeModel);
    }

    @DeleteMapping(path = "/{id}")
    public void deletaCidade(@PathVariable Long id){

        cidadeService.deletaCidade(id);
    }
}
