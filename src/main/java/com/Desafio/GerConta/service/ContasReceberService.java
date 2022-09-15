package com.Desafio.GerConta.service;

import com.Desafio.GerConta.FactoryCalculo.RecebimentoCalculoFactory;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.RespostaRecebimentoModel;
import com.Desafio.GerConta.model.enums.StatusPagamento;
import com.Desafio.GerConta.model.enums.TipoPagamento;
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

    @Autowired
    private RecebimentoCalculoFactory recebimentoCalculoFactory;

    public List<RespostaRecebimentoModel> buscarTudo(){
        List<ContasReceberModel> buscarNome = contasReceberRepository.findAll();
        return buscarNome.stream().map(recebimento1 -> new RespostaRecebimentoModel(recebimento1.getId(), recebimento1.getRecebimento(), recebimento1.getValorRecebido(), recebimento1.getTipoRecebimento(),recebimento1.getDataDeVencimento(),recebimento1.getDataDeRecebimento(),recebimento1.getStatus(),recebimento1.getId())).collect(Collectors.toList());
    }

    public Optional<ContasReceberModel> buscaPorId(Long id){
        return contasReceberRepository.findById(id);
    }

    public List<ContasReceberModel> TipoRecebimento (TipoRecebimento tipoRecebimento){
        return contasReceberRepository.findBytipoRecebimento(tipoRecebimento);
    }

    public List<ContasReceberModel> statusConta (StatusPagamento status){
        return contasReceberRepository.findByStatus(status);
    }

    public List<ContasReceberModel> buscaDataVencimento (LocalDateTime dataDeVencimento){
        return contasReceberRepository.findBydataDeVencimento(dataDeVencimento);
    }

    public ContasReceberModel cadastraContaReceber(ContasReceberModel contasReceberModel){
        contasReceberModel.setDataDeRecebimento(null);
        boolean recebNoPrazo = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if(!recebNoPrazo){
            contasReceberModel.setStatus(StatusPagamento.VENCIDA);
        }else {
            contasReceberModel.setStatus(StatusPagamento.AGUARDANDO);
        }
        return contasReceberRepository.save(contasReceberModel);
    }

    public ContasReceberModel alteraContaReceber(ContasReceberModel contaRequest){

        Optional<ContasReceberModel> optContaDB = contasReceberRepository.findById(contaRequest.getId());
        if(optContaDB.isEmpty())throw new IllegalArgumentException("O Id Informado nao esta no Banco de Dados");

        var contaDB = optContaDB.get();

        if(contaDB.getStatus() == StatusPagamento.PAGO) throw new IllegalArgumentException("A conta com Id " +contaDB.getId() + " ja foi paga");

        if(contaRequest.getStatus() == StatusPagamento.PAGO){
            contaDB.setDataDeRecebimento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            contaDB.setStatus(StatusPagamento.PAGO);

            if(contaDB.getTipoRecebimento().equals(TipoRecebimento.ALUGUEIS)){
                if(contaDB.getDataDeVencimento().isBefore(LocalDate.now())){
                    contaDB.setTipoPagamento(TipoPagamento.EM_ATRASO);
                }else if(contaDB.getDataDeVencimento().isAfter(LocalDate.now())){
                    contaDB.setTipoPagamento(TipoPagamento.ADIANTADO);
                }else {
                    contaDB.setTipoPagamento(TipoPagamento.EM_DIA);
                }

                var calculo = contaDB.getTipoPagamento().getCalculo();
                BigDecimal result = calculo.calcularRecebimento(contaDB);;
                contaDB.setValorRecebido(result);

            }

        }

        return contasReceberRepository.save(contaDB);

    }

    public void deletaContaReceber(Long id){
        contasReceberRepository.deleteById(id);
    }

}
