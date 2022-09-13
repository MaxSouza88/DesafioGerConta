package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.EnderecoModel;
import com.Desafio.GerConta.model.EstadoModel;
import com.Desafio.GerConta.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public Iterable<EstadoModel> buscaTudo(){

        return estadoService.buscarEstado();
    }

    @GetMapping(path = "/estados/{id}")
    public Optional<EstadoModel> buscaEstadoId(@PathVariable Long id){

        return estadoService.buscarEstadoId(id);
    }

    @PostMapping(path = "/estados")
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoModel cadastraEstado (@RequestBody EstadoModel estadoModel){

        return estadoService.cadastraEstado(estadoModel);
    }

    @PutMapping(path = "estados/{id}")
    public EstadoModel alteraEstado(@ RequestBody EstadoModel estadoModel){

        return estadoService.alteraCadEstado(estadoModel);
    }

    @DeleteMapping(path = "estados/{id}")
    public void deletaEstado(@PathVariable Long id){

        estadoService.deletaEstado(id);
    }

}
