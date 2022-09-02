package com.apipagamento.totalshake.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(url = "http://localhost:8080/pedidos", name = "TotalShakeAPI")
public interface PedidoEndPoint {


    @PutMapping("pedidos/{id}")
    void atualizaStatusPedido(@PathVariable Long id);

}



