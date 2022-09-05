package com.apipagamento.totalshake.service;

import com.apipagamento.totalshake.dtoRequest.PagamentoDtoRequest;
import com.apipagamento.totalshake.dtoRequest.StatusRequest;
import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.feign.PedidoEndPoint;
import com.apipagamento.totalshake.feign.request.PedidoRequest;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.model.Status;
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

    @Autowired
    private PedidoEndPoint pedidoEndPoint;


    public List<PagamentoDtoResponse> getAll() {
        return pagamentoRepository.findAll().stream().map(pagamento -> modelMapper.map(pagamento,PagamentoDtoResponse.class)).toList();
    }
   public PagamentoDtoResponse getPagamentoById(Long id) {
       Optional<Pagamento> obj = pagamentoRepository.findById(id);
       Pagamento pagamento = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
       return new PagamentoDtoResponse(pagamento);
   }

    public PagamentoDtoResponse insert (Pagamento pagamento) {
        return new PagamentoDtoResponse(pagamentoRepository.save(pagamento));
    }
    public PagamentoDtoResponse update(Long id, StatusRequest statusRequest) {
       Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Id Not Found"));
       pagamento = atualizaStatusPagamento(pagamento, statusRequest.getStatus());

       pagamentoRepository.save(pagamento);

       if(statusRequest.getStatus().equals(Status.CONFIRMADO.toString())){

           atualizaStatusPedido(pagamento.getPedidoId());
       }
       return new PagamentoDtoResponse(pagamento);

    }
    public void delete(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
    }


    private Pagamento atualizaStatusPagamento(Pagamento model, String status){
        model.setStatus(Status.valueOf(status));
        return model;
    }



    public void atualizaStatusPedido( Long id){

        pedidoEndPoint.atualizaPedido(id, new PedidoRequest("PAGO"));
    }

}



