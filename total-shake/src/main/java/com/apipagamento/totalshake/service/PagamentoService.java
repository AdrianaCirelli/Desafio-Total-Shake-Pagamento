package com.apipagamento.totalshake.service;

import com.apipagamento.totalshake.dtoRequest.PagamentoDtoRequest;
import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.repository.PagamentoRepository;
import com.apipagamento.totalshake.service.exeception.ResourceNotFoundExeception;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {


    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<PagamentoDtoResponse> getAll() {
        return pagamentoRepository.findAll().stream().map(pagamento -> modelMapper.map(pagamento,PagamentoDtoResponse.class)).toList();
    }
   public PagamentoDtoResponse getPagamentoById(Long id) {
       Optional<Pagamento> obj = pagamentoRepository.findById(id);
       Pagamento pagamento = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
       return new PagamentoDtoResponse(pagamento);
   }

    public PagamentoDtoResponse insert (Pagamento pagamento) {
        return new PagamentoDtoResponse(pagamentoRepository.save(pagamento)) ;
    }
    public PagamentoDtoResponse update(Long id, PagamentoDtoRequest pagamentoDtoRequest) {
       Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Id Not Found"));
        //ModelMapper : mapeia x para y - p aasagem de valores para os atributos de outra classe
        Pagamento pagamentoAtualizado = pagamentoRepository.save(modelMapper.map(pagamentoDtoRequest, Pagamento.class));
        return   modelMapper.map(pagamentoAtualizado, PagamentoDtoResponse.class);
    }

    public void delete(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
    }

}



