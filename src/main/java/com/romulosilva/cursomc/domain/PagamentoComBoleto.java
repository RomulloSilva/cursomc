package com.romulosilva.cursomc.domain;

import com.romulosilva.cursomc.domain.Enuns.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = -4217758553925311296L;

    private LocalDateTime dataVencimento;
    private LocalDateTime dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, LocalDateTime dataVencimento, LocalDateTime dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


}
