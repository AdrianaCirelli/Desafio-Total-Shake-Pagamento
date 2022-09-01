package com.apipagamento.totalshake.dtoResponse;

import com.apipagamento.totalshake.model.FormaDePagamento;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.model.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class PagamentoDtoResponse {

    @Positive
    @NotNull
    private BigDecimal valor;

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String numero;

    private String expiracao;

    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;

    private Status status;

    private Long pedidoId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

    public PagamentoDtoResponse(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.valor = pagamento.getValor();
        this.nome = pagamento.getNome();
        this.numero = pagamento.getNumero();
        this.expiracao = pagamento.getExpiracao();
        this.codigo = pagamento.getCodigo();
        this.status = pagamento.getStatus();
        this.pedidoId = pagamento.getPedidoId();
        this.formaDePagamento = pagamento.getFormaDePagamento();
    }

    public PagamentoDtoResponse(BigDecimal valor, String nome, String expiracao, String codigo, Status status, Long pedidoId) {
    }
}
