package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.RespostaSelecionadaModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.repository.ContasAPagarRepository;
import com.Desafio.GerConta.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    @GetMapping
    public List<RespostaSelecionadaModel> buscarTudo(){
        return contasAPagarService.buscarTudo();
    }

    @GetMapping(path = "/{id}")
    public Optional<ContasAPagarModel> buscaId(@PathVariable Long id){
        return contasAPagarService.buscaPorId(id);
    }

    @GetMapping(path = "/tipo/{tipoConta}")
    public ResponseEntity<List<ContasAPagarModel>> tipoDeConta(@PathVariable TipoEnum tipoConta){
        return ResponseEntity.ok(contasAPagarService.tipoConta(tipoConta));
    }

    @GetMapping(path = "/status/{statusDaConta}")
    public ResponseEntity<List<ContasAPagarModel>> findBYStatusDaConta(@PathVariable StatusEnum status){
        return ResponseEntity.ok(contasAPagarService.statusConta(status));
    }

    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarConta(@RequestBody ContasAPagarModel contasAPagarModel){
        ContasAPagarModel contas = contasAPagarService.cadastraConta(contasAPagarModel);
        return new ResponseEntity<>(contas,HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ContasAPagarModel> alterarConta(@PathVariable Long id,@RequestBody ContasAPagarModel contasAPagarModel){
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasAPagarService.alteraConta(contasAPagarModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletaConta(@PathVariable Long id){
        contasAPagarService.deletaConta(id);
    }





}
