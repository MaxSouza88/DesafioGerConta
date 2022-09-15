package com.Desafio.GerConta.controller;
import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.RespostaSelecionadaModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.repository.ContasPagarRepository;
import com.Desafio.GerConta.service.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contas")
public class ContasPagarController {

    @Autowired
    private ContasPagarService contasPagarService;
    @Autowired
    private ContasPagarRepository contasPagarRepository;

    @GetMapping
    public ResponseEntity<List<RespostaSelecionadaModel>> buscarTudo () {
        return ResponseEntity.ok(contasPagarService.buscarTudo());
    }

    @GetMapping(path = "/{id}")
    public Optional<ContasAPagarModel> buscaId(@PathVariable Long id){
        return contasPagarService.buscaPorId(id);
    }

    @GetMapping(path = "/tipoEnum/{tipo}")
    public ResponseEntity<List<ContasAPagarModel>> tipoDeConta(@PathVariable TipoEnum tipoEnum){
        return ResponseEntity.ok(contasPagarService.tipoConta(tipoEnum));
    }

    @GetMapping(path = "/statusEnum/{status}")
    public ResponseEntity<List<ContasAPagarModel>> findBYStatusDaConta(@PathVariable StatusEnum status){
        return ResponseEntity.ok(contasPagarService.statusConta(status));
    }

    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarConta(@RequestBody ContasAPagarModel contasAPagarModel){
        ContasAPagarModel contas = contasPagarService.cadastraConta(contasAPagarModel);
        return new ResponseEntity<>(contas,HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ContasAPagarModel> alterarConta(@PathVariable Long id,@RequestBody ContasAPagarModel contasAPagarModel){
        if (!contasPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasPagarService.alteraConta(contasAPagarModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletaConta(@PathVariable Long id){
        contasPagarService.deletaConta(id);
    }

}
