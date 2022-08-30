package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.RespostaSelecionadaModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository contasPagarRepository;

    public List<RespostaSelecionadaModel> buscarTudo(){
        List<ContasAPagarModel> buscarNome = contasPagarRepository.findAll();
        return buscarNome.stream().map(teste1 -> new RespostaSelecionadaModel(teste1.getId(), teste1.getNomeConta(), teste1.getValor(), teste1.getStatus())).collect(Collectors.toList());
    }

    public Optional<ContasAPagarModel> buscaPorId(Long id){
        return contasPagarRepository.findById(id);
    }
    public List<ContasAPagarModel> tipoConta (TipoEnum tipoEnum){
        return contasPagarRepository.findByTipoConta(tipoEnum);
    }

    public List<ContasAPagarModel> statusConta (StatusEnum status){
        return contasPagarRepository.findByStatus(status);
    }

    public ContasAPagarModel cadastraConta(ContasAPagarModel contasAPagarModel){
        contasAPagarModel.setDataDePagamento(null);

        Boolean pagNoPrazo = LocalDate.now().isBefore(contasAPagarModel.getDataDeVencimento()) || LocalDate.now().equals(contasAPagarModel.getDataDeVencimento());
        if(Boolean.FALSE.equals(pagNoPrazo)){
            contasAPagarModel.setStatus(StatusEnum.VENCIDA);
        }else {
            contasAPagarModel.setStatus(StatusEnum.AGUARDANDO);
        }
        return contasPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alteraConta(ContasAPagarModel contasAPagarModel){
        ContasAPagarModel alteraConta = contasPagarRepository.findById(contasAPagarModel.getId()).get();
        if(contasAPagarModel.getStatus() == StatusEnum.PAGO){
            alteraConta.setDataDePagamento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            alteraConta.setStatus(StatusEnum.PAGO);
        }return contasPagarRepository.save(alteraConta);
    }

    public void deletaConta(Long id){
        contasPagarRepository.deleteById(id);
    }

}
