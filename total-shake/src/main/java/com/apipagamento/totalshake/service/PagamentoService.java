package com.apipagamento.totalshake.service;

import com.apipagamento.totalshake.dtoRequest.PagamentoDtoRequest;
import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.repository.PagamentoRespository;
import com.apipagamento.totalshake.service.exeception.ResourceNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PagamentoService {


    @Autowired
    PagamentoRespository pagamentoRepository;


    public ResponseEntity<PagamentoDtoResponse> getAll() {
        return ResponseEntity.ok(new PagamentoDtoResponse((Pagamento) pagamentoRepository.findAll()));
    }
   public PagamentoDtoResponse getPagamentoById(Long id) {
       Optional<Pagamento> obj = pagamentoRepository.findById(id);
       Pagamento pagamento = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
       return new PagamentoDtoResponse(pagamento);
   }

    public PagamentoDtoResponse insert  (Pagamento pagamento) {
        return ResponseEntity.ok(new PagamentoDtoResponse(pagamentoRepository.save(pagamento))).getBody();
    }


    public PagamentoDtoResponse update(Long id, PagamentoDtoRequest pagamentoDtoRequest) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            pagamentoRepository.save(new Pagamento());
            System.out.println("Pagamento Atualizado");
        } throw new ResourceNotFoundExeception("Id Not Found.");

    }


    public void delete(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
    }



}



