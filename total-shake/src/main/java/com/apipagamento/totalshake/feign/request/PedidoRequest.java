package com.apipagamento.totalshake.feign.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PedidoRequest {

    @Length(min = 10)
    private  String status;


   public PedidoRequest(){

    }

    public PedidoRequest(String status) {
        this.status = status;
    }

}
