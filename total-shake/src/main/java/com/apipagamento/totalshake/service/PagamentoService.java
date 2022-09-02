package com.apipagamento.totalshake.service;

import com.apipagamento.totalshake.dtoRequest.PagamentoDtoRequest;
import com.apipagamento.totalshake.dtoResponse.PagamentoDtoResponse;
import com.apipagamento.totalshake.model.Pagamento;
import com.apipagamento.totalshake.repository.PagamentoRepository;
import com.apipagamento.totalshake.service.exeception.ResourceNotFoundExeception;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
public class PagamentoService {


    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<PagamentoDtoResponse> getAll() {
        return ResponseEntity.ok(new PagamentoDtoResponse((Pagamento) pagamentoRepository.findAll()));
    }
   public PagamentoDtoResponse getPagamentoById(Long id) {
       Optional<Pagamento> obj = pagamentoRepository.findById(id);
       Pagamento pagamento = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
       return new PagamentoDtoResponse(pagamento);
   }

    public PagamentoDtoResponse insert (Pagamento pagamento) {
        return new PagamentoDtoResponse(pagamentoRepository.save(pagamento)) ;
    }

    private Pagamento atualizarPagamento(Pagamento model,  PagamentoDtoRequest request) {
        model.setValor(request.getValor());
        model.setNome(request.getNome());
        model.setNumero(request.getNumero());
        model.setExpiracao(request.getExpiracao());
        model.setCodigo(request.getCodigo());
        model.setStatus(request.getStatus());
        model.setPedidoId(request.getPedidoId());
        model.setFormaDePagamento(request.getFormaDePagamento());
        return model;
    }


    public PagamentoDtoResponse update(Long id, PagamentoDtoRequest pagamentoDtoRequest) {
       Pagamento pagamento = pagamentoRepository.findById(id).get();
        if (pagamento == null) {
            throw new ResourceNotFoundExeception("Id Not Found.");
        }
        Pagamento pagamentoAtualizado = pagamentoRepository.save(atualizarPagamento(pagamento, pagamentoDtoRequest));
        return pagamentoAtualizado.toDtoResponse();

    }


    public void delete(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
    }

}



