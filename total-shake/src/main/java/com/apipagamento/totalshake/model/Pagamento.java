package com.apipagamento.totalshake.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tb_pagamento")
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;

    private Status status;

    private Long pedidoId;

    private FormaDePagamento formaDePagamento;

    public Pagamento() {
    }

    public Pagamento(BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento) {
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamento = formaDePagamento;
    }



}
