package com.apipagamento.totalshake.feign;

import com.apipagamento.totalshake.feign.request.PedidoRequest;
import com.apipagamento.totalshake.model.Pagamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "http://localhost:8080/pedidos", name = "TotalShakeAPI")
public interface PedidoEndPoint {
    @PutMapping("/{id}")
    void atualizaPedido(@PathVariable Long id, @RequestBody PedidoRequest form);

}



