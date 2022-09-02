package com.apipagamento.totalshake.repository;

import com.apipagamento.totalshake.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


}
