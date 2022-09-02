package com.apipagamento.totalshake.controller;


import com.apipagamento.totalshake.dtoRequest.PagamentoDtoRequest;
import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping (value = "/pagamentos")
public class PagamentoController {
    @Autowired
    PagamentoService pagamentoService;

    //fluxo correto: controller para service , da service para repository

    @GetMapping(value = "/{id}")
    public ResponseEntity<PagamentoDtoResponse> getPAgamentoById (@PathVariable Long id) {
        PagamentoDtoResponse pagamento= pagamentoService.getPagamentoById(id);
        return ResponseEntity.ok().body(pagamento);
    }
    @PostMapping
    public ResponseEntity <PagamentoDtoResponse> insert (@RequestBody PagamentoDtoRequest pagamentoDtoRequest){
        Pagamento pagamento  = pagamentoDtoRequest.toModel();
        pagamentoService.insert(pagamento);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PagamentoDtoResponse> update (@PathVariable Long  id, @RequestBody PagamentoDtoRequest pagamentoDtoRequest){
        return ResponseEntity.ok().body(pagamentoService.update(id, pagamentoDtoRequest));

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PagamentoDtoResponse> delete(@PathVariable Long id){
       pagamentoService.delete(id);
      return ResponseEntity.noContent().build();
    }


}
