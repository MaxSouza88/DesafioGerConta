package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.RespostaRecebimentoModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import com.Desafio.GerConta.repository.ContasReceberRepository;
import com.Desafio.GerConta.service.ContasReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/receber")
public class ContaReceberController {

    @Autowired
    private ContasReceberService contasReceberService;

    @Autowired
    private ContasReceberRepository contasReceberRepository;

    @GetMapping
    public ResponseEntity<List<RespostaRecebimentoModel>> buscarTudo () {
        return ResponseEntity.ok(contasReceberService.buscarTudo());
    }

    @GetMapping(path = "/{id}")
    public Optional<ContasReceberModel> buscaId(@PathVariable Long id){
        return contasReceberService.buscaPorId(id);
    }

    @GetMapping(path = "/tipoRecebimento/{tipo}")
    public ResponseEntity<List<ContasReceberModel>> tipoDeConta(@PathVariable TipoRecebimento tipoRecebimento){
        return ResponseEntity.ok(contasReceberService.TipoRecebimento(tipoRecebimento));
    }

    @GetMapping(path = "/statusEnum/{status}")
    public ResponseEntity<List<ContasReceberModel>> findBYStatusDaConta(@PathVariable StatusEnum status){
        return ResponseEntity.ok(contasReceberService.statusConta(status));
    }

    @GetMapping(path = "/{dataDeRecebimento}")
    public ResponseEntity<List<ContasReceberModel>> buscaData(@PathVariable LocalDateTime dataDeVencimento){
        return ResponseEntity.ok(contasReceberService.buscaDataVencimento(dataDeVencimento));
    }


    @PostMapping
    public ResponseEntity<ContasReceberModel> cadastrarConta(@RequestBody ContasReceberModel contasReceberModel){
        ContasReceberModel contasReceberModel1 = contasReceberService.cadastraContaReceber(contasReceberModel);
        return new ResponseEntity<>(contasReceberModel1, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ContasReceberModel> alterarConta(@PathVariable Long id,@RequestBody ContasReceberModel contasReceberModel){
        if (!contasReceberRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasReceberService.alteraContaReceber(contasReceberModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletaConta(@PathVariable Long id){

        contasReceberService.deletaContaReceber(id);
    }

}

