package com.Desafio.GerConta.service;

import com.Desafio.GerConta.FactoryCalculo.RecebimentoFactory;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.RespostaRecebimentoModel;
import com.Desafio.GerConta.model.enums.RecebimentoAlugueis;
import com.Desafio.GerConta.model.enums.StatusEnum;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import com.Desafio.GerConta.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

//    public List<ContasReceberModel> buscaDataVencimento (LocalDateTime dataDeRecebimento){
//        return contasReceberRepository.findByDataVencimento(dataDeRecebimento);
//    }

    public ContasReceberModel cadastraContaReceber(ContasReceberModel contasReceberModel){
        contasReceberModel.setDataDeRecebimento(null);
        boolean recebNoPrazo = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if(!recebNoPrazo){
            contasReceberModel.setStatus(StatusEnum.VENCIDA);
        }else {
            contasReceberModel.setStatus(StatusEnum.AGUARDANDO);
        }
        return contasReceberRepository.save(contasReceberModel);
    }

    public ContasReceberModel alteraContaReceber(ContasReceberModel contaRequest, RecebimentoFactory factory){

        Optional<ContasReceberModel> optContaDB = contasReceberRepository.findById(contaRequest.getId());
        if(optContaDB.isEmpty())throw new IllegalArgumentException("O Id Informado nao esta no Banco de Dados");

        var contaDB = optContaDB.get();

        if(contaDB.getStatus() == StatusEnum.PAGO)throw new IllegalArgumentException("A conta com Id " +contaDB.getId() + " ja foi paga");

        if(contaRequest.getStatus() == StatusEnum.PAGO){
            contaDB.setDataDeRecebimento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            contaDB.setStatus(StatusEnum.PAGO);

            if(contaRequest.getTipoRecebimento().equals(TipoRecebimento.ALUGUEIS)){
                if(contaRequest.getDataDeVencimento().isBefore(LocalDate.now())){
                    contaRequest.setTipoPagamento(RecebimentoAlugueis.EM_ATRASO);
                }else if(contaRequest.getDataDeVencimento().isAfter(LocalDate.now())){
                    contaRequest.setTipoPagamento(RecebimentoAlugueis.ADIANTADO);
            }else {
                    contaRequest.setTipoPagamento(RecebimentoAlugueis.EM_DIA);
                }

                BigDecimal result = factory.recebimentoAlugueis(contaRequest.getValorRecebido());
                contaRequest.getValorRecebido(result);

            }

        }

        return contasReceberRepository.save(contaDB);

    }

    public void deletaContaReceber(Long id){
        contasReceberRepository.deleteById(id);
    }



}
