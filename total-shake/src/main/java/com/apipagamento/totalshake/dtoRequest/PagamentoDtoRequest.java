package com.apipagamento.totalshake.dtoRequest;

import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.model.FormaDePagamento;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.model.Status;
import com.apipagamento.totalshake.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDtoRequest {

    @Positive
    @NotNull
    private BigDecimal valor;

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

    public Pagamento toModel (){
        return new Pagamento (valor, nome, numero,expiracao, codigo, status, pedidoId, formaDePagamento);
    }


}

