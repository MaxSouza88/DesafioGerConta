package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.RespostaRecebimentoModel;
import com.Desafio.GerConta.model.RespostaSelecionadaModel;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import com.Desafio.GerConta.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContasReceberService {

    @Autowired
    private ContasReceberRepository contasReceberRepository;

    public List<RespostaRecebimentoModel> buscarTudo(){
        List<ContasReceberModel> buscarNome = contasReceberRepository.findAll();
        return buscarNome.stream().map(recebimento1 -> new RespostaRecebimentoModel(recebimento1.getId(), recebimento1.getRecebimento(), recebimento1.getValorRecebido(), recebimento1.getStatus())).collect(Collectors.toList());
    }

    public Optional<ContasReceberModel> buscaPorId(Long id){
        return contasReceberRepository.findById(id);
    }

    public List<ContasReceberModel> TipoRecebimento (TipoRecebimento tipoRecebimento){
        return contasReceberRepository.findBytipoRecebimento(tipoRecebimento);
    }

    public List<ContasReceberModel> statusConta (StatusEnum status){
        return contasReceberRepository.findByStatus(status);
    }

    public ContasReceberModel cadastraContaReceber(ContasReceberModel contasReceberModel){
        contasReceberModel.setDataDeRecebimento(null);

        Boolean recebNoPrazo = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if(Boolean.FALSE.equals(recebNoPrazo)){
            contasReceberModel.setStatus(StatusEnum.VENCIDA);
        }else {
            contasReceberModel.setStatus(StatusEnum.AGUARDANDO);
        }
        return contasReceberRepository.save(contasReceberModel);
    }

    public ContasReceberModel alteraContaReceber(ContasReceberModel contasReceberModel){
        ContasReceberModel alteraContaReceber = contasReceberRepository.findById(contasReceberModel.getId()).get();
        if(contasReceberModel.getStatus() == StatusEnum.PAGO){
            alteraContaReceber.setDataDeRecebimento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            alteraContaReceber.setStatus(StatusEnum.PAGO);
        }return contasReceberRepository.save(alteraContaReceber);
    }

    public void deletaContaReceber(Long id){
        contasReceberRepository.deleteById(id);
    }



}
