package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.EnderecoModel;
import com.Desafio.GerConta.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public Iterable<EnderecoModel> buscaTudo(){

        return enderecoService.buscarEnderecos();
    }

    @GetMapping(path = "/enderecos/{id}")
    public Optional<EnderecoModel> buscaEndId(@PathVariable Long id){

        return enderecoService.buscarEndId(id);
    }

    @PostMapping(path = "/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoModel cadastraEndereco (@RequestBody EnderecoModel enderecoModel){

        return enderecoService.cadastraEndereco(enderecoModel);
    }

    @PutMapping(path = "enderecos/{id}")
    public EnderecoModel alteraEndereco(@ RequestBody EnderecoModel enderecoModel){

        return enderecoService.alteraCadEndereco(enderecoModel);
    }

    @DeleteMapping(path = "enderecos/{id}")
    public void deletaEndereco(@PathVariable Long id){

        enderecoService.deletaEndereco(id);
    }
}
